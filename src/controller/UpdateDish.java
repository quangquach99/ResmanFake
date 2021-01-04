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
 * Servlet implementation class UpdateDish
 */
@WebServlet("/UpdateDish")
public class UpdateDish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DishDao UpdateDish;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dishName = request.getParameter("dishName");
		int dishType = Integer.parseInt(request.getParameter("dishType"));
		float dishPrice = Float.parseFloat(request.getParameter("dishPrice"));
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		Dish dish = new Dish(dishName,dishType,dishPrice);
		dish.setDishId(dishId);
		boolean insertNewReservation =UpdateDish.updateDish(dish);
			if(insertNewReservation) {
				response.sendRedirect("Home?success=0001");
			} else {
				response.sendRedirect("Home?error=0002");
			}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
