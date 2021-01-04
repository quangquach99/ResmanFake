package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;

/**
 * Servlet implementation class DeleteDish
 */
@WebServlet("/DeleteDish")
public class DeleteDish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DishDao DeleteDish;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int dishId = Integer.parseInt(request.getParameter("dishId"));
	        DeleteDish.deledteDish(dishId);
		    response.sendRedirect("http://localhost/Resman/Admin/Table");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
