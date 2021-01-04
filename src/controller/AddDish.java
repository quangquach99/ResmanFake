package controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;

import model.Dish;


/**
 * Servlet implementation class AddDish
 */
@WebServlet("/AddDish")
public class AddDish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DishDao AddDish = new DishDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		// Get reservation information
    	String dishName = request.getParameter("dishName");
		int dishType = Integer.parseInt(request.getParameter("dishType"));
		float dishPrice = Float.parseFloat(request.getParameter("dishPrice"));
		Dish dish = new Dish(dishName,dishType,dishPrice);
		   
			boolean insertNewReservation =AddDish.insertDish(dish);
			if(insertNewReservation) {
				response.sendRedirect("Home?success=0001");
			} else {
				response.sendRedirect("Home?error=0002");
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
