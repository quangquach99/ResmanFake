package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;

@WebServlet("/SetSessionReservation")
public class SetSessionReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET Reservation ID
		int reservationId = Integer.parseInt(request.getParameter("reservationId"));
		HttpSession session = request.getSession();
		session.setAttribute("reservationId", reservationId);
		System.out.println(session.getAttribute("reservationId"));
		List<Order> orders = new ArrayList<>();
		session.setAttribute("orders", orders);
		response.sendRedirect("DishSearch");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
