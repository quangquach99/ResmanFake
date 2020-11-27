package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cryptography.Crypt;
import dao.DishDao;
import dao.LoginDao;
import dao.OrderDao;
import dao.ReservationDao;
import model.Dish;
import model.Manager;
import model.Order;
import model.Reservation;
import model.RevenueByDish;

@WebServlet("/")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uris = request.getRequestURI().split("/");
		if(uris.length > 2) {
			String admin = (String) uris[2];
			if(admin.equalsIgnoreCase("Admin")) {
				HttpSession session = request.getSession();
				if(session.getAttribute("authenticated") == null) {
					if(uris.length > 3 && uris[3].equalsIgnoreCase("LoginController")) {
						// LOGIN CONTROLLER
						loginValidate(request,response);
						return;
					}
					// NEED TO LOG IN
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
				} else {
					if(uris.length > 3) {
						switch(uris[3]) {
						 case "RevenueByDish":
							 // REVENUE BY DISH PAGE
							 revenueByDish(request, response);
							 break;
						 case "DetailRevenueByDish":
							 // DETAIL REVENUE BY DISH PAGE
							 detailRevenueByDish(request, response);
							 break;
						 case "DetailInvoice":
							 // DETAIL INVOICE PAGE
							 detailInvoice(request, response);
							 break;
						 case "Logout":
							 // LOGOUT ACTION
							 logout(request, response);
							 break;
						 default:
							// DASHBOARD PAGE
							 dashBoardPage(request, response);
							 break;
						}
					} else {
						// DASHBOARD PAGE
						dashBoardPage(request, response);
					}
				}
			} else {
				String[] availableControllers = {"AddDishToOrder","ConfirmOrder","DishSearch","GetReservations","Home","ReservationConfirm","ReservationSearch","SaveReservation","SetSessionReservation"};
				if(!Arrays.asList(availableControllers).contains(uris[2])) {
					response.sendRedirect("https://localhost/Resman/NotFound");
				}
			}
		} else {
			response.sendRedirect("https://localhost/Resman/Home");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void loginValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// GET Email And Password
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		int userLevel = Integer.parseInt(request.getParameter("level"));
		
		Manager manager = new LoginDao().validateManager(new Manager(userEmail));
		Crypt crypt = new Crypt();
		
		if(userLevel == 3) {
			System.out.println(userEmail);
			System.out.println(userPassword);
			
			if(manager != null) {
				System.out.println(manager.getUserPassword());
				System.out.println(crypt.caesarCipherEncrypt(userPassword));
				if(!manager.getUserPassword().equals(crypt.caesarCipherEncrypt(userPassword))) {
					response.sendRedirect("https://localhost/Resman/Admin?error=0006&userEmail="+userEmail);
				} else {
					String managerFullname = manager.getUserFullName();
					HttpSession session = request.getSession();
					session.setAttribute("authenticated", true);
					session.setAttribute("managerFullname", managerFullname);
					response.sendRedirect("https://localhost/Resman/Admin?success=0003");
				}
			} else {
				response.sendRedirect("https://localhost/Resman/Admin?error=0007&userEmail="+userEmail);
			}
			
		} else {
			response.sendRedirect("https://localhost/Resman/Admin?error=0006&userEmail="+userEmail);
		}
	}

	private void dashBoardPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("authenticated");
		session.removeAttribute("managerFullname");
		response.sendRedirect("https://localhost/Resman/Admin");
	}
	
	private void revenueByDish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Date startDate;
		Date endDate;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));
			int listOfDishId[] = new OrderDao().getDishIdsByDate(startDate, endDate);
			List<RevenueByDish> revenueByDishList = new ArrayList<>();
			for(int i = 0; i < listOfDishId.length; i++) {
				if(listOfDishId[i] != 0) {
					Dish dish = new DishDao().getDishById(listOfDishId[i]);
					float revenueTotal = new OrderDao().getRevenueTotal(startDate, endDate, listOfDishId[i]);
					revenueByDishList.add(new RevenueByDish(startDate, endDate, revenueTotal, dish));
				}
			}
			request.setAttribute("startDate", request.getParameter("startDate"));
			request.setAttribute("endDate", request.getParameter("endDate"));
			request.setAttribute("revenueByDishList", revenueByDishList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/revenueByDish.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void detailRevenueByDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		// GET DISH INFORMATION
		Dish dish = new DishDao().getDishById(dishId);
		try {
			List<Order> orders = new OrderDao().getOrdersByRevenue(startDate, endDate, dishId);
			request.setAttribute("dish", dish);
			request.setAttribute("orders", orders);
			request.setAttribute("startDate", request.getParameter("startDate"));
			request.setAttribute("endDate", request.getParameter("endDate"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/detailRevenueByDish.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void detailInvoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reservationId = Integer.parseInt(request.getParameter("reservationId"));
		try {
			// GET RESERVATION INFORMATION
			Reservation reservation = new ReservationDao().getReservationById(reservationId);
			request.setAttribute("reservation", reservation);
			// GET ORDERS OF THE RESERVATION
			List<Order> orders = new OrderDao().getOrdersByReservationId(reservationId);
			request.setAttribute("orders", orders);
			// GET TOTAL BILL FOR THE RESERVAION
			float totalBill = new OrderDao().getReservationBill(reservationId);
			request.setAttribute("reservationBill", totalBill);
			// INVOICE PAGE
			RequestDispatcher dispatcher = request.getRequestDispatcher("/detailInvoice.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}