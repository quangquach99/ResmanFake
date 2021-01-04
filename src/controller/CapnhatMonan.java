package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;
import model.Dish;

@WebServlet("/capnhatmonan")
public class CapnhatMonan extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  //  int id = Integer.parseInt(req.getParameter("dishId"));
     
	    DishDao dishDAO = new DishDao();
		String dishName = req.getParameter("dishName");
		int dishType = Integer.parseInt(req.getParameter("dishType"));
		float dishPrice = Float.parseFloat(req.getParameter("dishPrice"));
		int dishId = Integer.parseInt(req.getParameter("dishId"));
		Dish dish = new Dish(dishName,dishType,dishPrice);
		dish.setDishId(dishId);
		dishDAO.updateDish(dish);
	    List<Dish> dishs = dishDAO.findAll();	
		req.setAttribute("listDish", dishs);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/ListDish.jsp");
		requestDispatcher.forward(req, resp);
 }

}
