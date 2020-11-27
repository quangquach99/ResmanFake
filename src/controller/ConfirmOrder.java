package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import model.Order;

/**
 * Servlet implementation class ConfirmOrder
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderDao orderDao;
    
    public void init() {
    	orderDao = new OrderDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// CHECK if customer checked their reservation first
		if(session.getAttribute("reservationId") == null) {
			response.sendRedirect("Home?error=0004");
			return;
		}
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) session.getAttribute("orders");
		if(orders.size() == 0) {
			response.sendRedirect("DishSearch?error=0005");
			return;
		} else {
			for (int i = 0; i < orders.size(); i++) {
				int reservationId = orders.get(i).getReservationId();
				int dishId = orders.get(i).getDishId();
				int dishQuantity = orders.get(i).getDishQuantity();
				float dishPrice = orders.get(i).getDishPrice();
				Order order = new Order(reservationId, dishId, dishQuantity, dishPrice);
				orderDao.insertNewOrder(order);
				System.out.println("-----");
	            System.out.println(orders.get(i).getDishId());
	            System.out.println(orders.get(i).getDishPrice());
	            System.out.println(orders.get(i).getDishQuantity());
	            System.out.println(orders.get(i).getReservationId());
	            System.out.println(orders.get(i).getOrderPrice());
	            System.out.println("-----");
	        }
			session.removeAttribute("reservationId");
			session.removeAttribute("orders");
			response.sendRedirect("Home?success=0002");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
