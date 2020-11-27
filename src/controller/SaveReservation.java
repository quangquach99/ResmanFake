package controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDao;
import model.Reservation;

/**
 * Servlet implementation class saveReservation
 */
@WebServlet("/SaveReservation")
public class SaveReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDao reservationDao;
	
	public void init() {
		reservationDao = new ReservationDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		// Get reservation information
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
		String bookingDateStr = request.getParameter("bookingDate");
		Date bookingDate;
		try {
			bookingDate = new SimpleDateFormat("yyyy-MM-dd").parse(bookingDateStr);
			String bookingTime = request.getParameter("bookingTime");
			String customerFullname = request.getParameter("customerFullname");
			String customerEmail = request.getParameter("customerEmail");
			String customerAddress = request.getParameter("customerAddress");
			String customerPhone = request.getParameter("customerPhone");
			Reservation reservation = new Reservation(tableId,numberOfPeople,customerFullname,customerEmail,customerAddress,customerPhone,bookingDate,bookingTime);
			
			boolean insertNewReservation = reservationDao.insertNewReservation(reservation);
			
			if(insertNewReservation) {
				response.sendRedirect("Home?success=0001");
			} else {
				response.sendRedirect("Home?error=0002");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
