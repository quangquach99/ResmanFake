package controller;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDao;
import model.Reservation;

/**
 * Servlet implementation class GetReservation
 */
@WebServlet("/GetReservations")
public class GetReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDao reservationDao;
	
	public void init() {
		reservationDao = new ReservationDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET Customer phone number
		String customerPhone = request.getParameter("customerPhone");
		Pattern pattern = Pattern.compile("^\\d{10}$");
	    Matcher matcher = pattern.matcher(customerPhone);
	    if(matcher.matches()) {	
	    	try {
				List<Reservation> reservations = reservationDao.getReservationsByPhone(customerPhone);
				request.setAttribute("reservations", reservations);
				request.setAttribute("customerPhone", customerPhone);
				request.setAttribute("dates", next7Days());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/reservationsByPhone.jsp");
				dispatcher.forward(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	    	response.sendRedirect("Home?error=0003");
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
