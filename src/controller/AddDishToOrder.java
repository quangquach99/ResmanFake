package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
/**
 * Servlet implementation class AddDishToOrder
 */
@WebServlet("/AddDishToOrder")
public class AddDishToOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// CHECK if customer checked their reservation first
		if(session.getAttribute("reservationId") == null) {
			response.sendRedirect("Home?error=0004");
			return;
		}
		// GET Order Information
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		int reservationId = (int) session.getAttribute("reservationId");
		float dishPrice = Float.parseFloat(request.getParameter("dishPrice"));
		int dishQuantity = Integer.parseInt(request.getParameter("dishQuantity"));
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) session.getAttribute("orders");
		orders.add(new Order(reservationId, dishId, dishQuantity, dishPrice));
		session.setAttribute("orders", orders);
		
		response.sendRedirect("DishSearch");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
