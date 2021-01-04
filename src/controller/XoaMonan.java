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

@WebServlet("/deletemonan")
public class XoaMonan  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 DishDao  dishDao = new DishDao();
    	 int id = Integer.parseInt(req.getParameter("dishId"));
    	// System.out.println("mã của món ăn là +"+ id);
    	 dishDao.deledteDish(id);
    	 List<Dish> dishs = dishDao.findAll();	
			req.setAttribute("listDish", dishs);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/ListDish.jsp");
			requestDispatcher.forward(req, resp);
    }
}
