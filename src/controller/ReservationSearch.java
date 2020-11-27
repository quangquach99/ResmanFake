package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TableDao;
import model.Table;

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/ReservationSearch")
public class ReservationSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TableDao tableDao;
	
	public void init() {
		tableDao = new TableDao();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CHECK CUSTOMER INPUT
		if(request.getParameter("bookingDate") == "" || request.getParameter("bookingTime") == "" || request.getParameter("numberOfPeople") == "") {
			response.sendRedirect("Home?error=0001");
			return;
		}
		// IF there is no parameters
		if (!request.getParameterMap().containsKey("bookingDate") || !request.getParameterMap().containsKey("bookingTime") || !request.getParameterMap().containsKey("numberOfPeople")) {
			response.sendRedirect("Home?error=0001");
			return;
        }
		
		// GET customer options
		String bookingDate = request.getParameter("bookingDate");
		String bookingTime = request.getParameter("bookingTime");
		int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
		
		request.setAttribute("bookingDate", bookingDate);
		request.setAttribute("bookingTime", bookingTime);
		request.setAttribute("numberOfPeople", numberOfPeople);
		request.setAttribute("dates", next7Days());
		List<Table> availableTables = tableDao.selectAvailableTables(numberOfPeople, bookingDate, bookingTime);
		request.setAttribute("tables", availableTables);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/reservationSearch.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String[] next7Days() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String[] result = {dtf.format(now),dtf.format(now.plusDays(1)),
				dtf.format(now.plusDays(2)),dtf.format(now.plusDays(3)),
				dtf.format(now.plusDays(4)),dtf.format(now.plusDays(5)),
				dtf.format(now.plusDays(6))};
		return result;
	}
}
