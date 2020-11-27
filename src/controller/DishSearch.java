package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;
import model.Dish;

@WebServlet("/DishSearch")
public class DishSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DishDao dishDao;
    
    public void init() {
    	dishDao = new DishDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dish> dishes = null;
		// CHECK if dish name and dish type parameter exists
        if (request.getParameterMap().containsKey("dishName") && request.getParameterMap().containsKey("dishType")) {
            if(request.getParameter("dishName") == "" && request.getParameter("dishType") == "") {
            	dishes = dishDao.getAllDish();
            } else if(request.getParameter("dishname") != "" && request.getParameter("dishType") == "") {
            	String dishName = request.getParameter("dishName");
            	dishes = dishDao.getDishesByName(dishName);
            } else if(request.getParameter("dishname") == "" && request.getParameter("dishType") != "") {
            	int dishType = Integer.parseInt(request.getParameter("dishType"));
            	dishes = dishDao.getDishesByType(dishType);
            } else {
            	String dishName = request.getParameter("dishName");
            	int dishType = Integer.parseInt(request.getParameter("dishType"));
            	dishes = dishDao.getDishesByNameAndType(dishName, dishType);
            }
        } else {
        	dishes = dishDao.getAllDish();
        }
        request.setAttribute("dates", next7Days());
        request.setAttribute("dishes", dishes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dishSearch.jsp");
        dispatcher.forward(request, response);
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
