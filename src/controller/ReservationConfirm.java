package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TableDao;
import model.Table;

/**
 * Servlet implementation class ReservationConfirm
 */
@WebServlet("/ReservationConfirm")
public class ReservationConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TableDao tableDao;
	
	public void init() {
		tableDao = new TableDao();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get Reservation Information
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
		String bookingDate = request.getParameter("bookingDate");
		String bookingTime = request.getParameter("bookingTime");
		
		Table table = tableDao.getTableById(tableId);
		
		request.setAttribute("bookingDate", bookingDate);
		request.setAttribute("bookingTime", bookingTime);
		request.setAttribute("numberOfPeople", numberOfPeople);
		request.setAttribute("table", table);
		request.setAttribute("dates", next7Days());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/reservationConfirm.jsp");
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
		// TODO Auto-generated method stub
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
