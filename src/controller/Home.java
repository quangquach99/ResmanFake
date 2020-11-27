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

import cryptography.Crypt;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Crypt crypt = new Crypt();
		System.out.println(crypt.caesarCipherEncrypt("Dinhquang_123!"));
		request.setAttribute("dates", next7Days());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
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
