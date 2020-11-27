package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Dish;
import model.Order;

public class OrderDao extends Dao {
	private static String INSERT_NEW_ORDER = "INSERT INTO `order`"
			+ "(`reservation_id`, `dish_id`, `dish_quantity`, `order_price`, `ordered_at`)" + 
			"VALUES(?, ?, ?, ?, ?);";
	private static String GET_DISH_IDS_BY_DATE = "SELECT DISTINCT `dish_id` FROM `order` WHERE `order_reg_date` BETWEEN ? AND ?;";
	private static String GET_DISH_REVENUE_TOTAL = "SELECT SUM(`order_price`) FROM `order` WHERE (`order_reg_date` BETWEEN ? AND ?) AND `dish_id` = ?;";
	private static String GET_ORDER_BY_REVENUE = "SELECT * FROM `order` WHERE `order_reg_date` BETWEEN ? AND ? AND `dish_id` = ?;";
	private static String GET_ORDER_BY_RESERVATION_ID = "SELECT * FROM `order` WHERE `reservation_id` = ?;";
	private static String GET_RESERVATION_BILL = "SELECT SUM(`order_price`) FROM `order` WHERE `reservation_id` = ?;";
	
	public OrderDao() {}
	
	//INSERT a new order
	public void insertNewOrder(Order order) {
    	try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER);) {
    		preparedStatement.setInt(1, order.getReservationId());
    		preparedStatement.setInt(2, order.getDishId());
    		preparedStatement.setInt(3, order.getDishQuantity());
    		preparedStatement.setFloat(4, order.getOrderPrice());
    		// SET Time format
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
    		LocalDateTime now = LocalDateTime.now();
    		preparedStatement.setString(5, dtf.format(now));
    		System.out.println(preparedStatement);
    		preparedStatement.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public int[] getDishIdsByDate(Date startDate, Date endDate) {
		int dishIds[] = new int[50];
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_DISH_IDS_BY_DATE);) {
	    		// DATE FORMAT
	    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    		preparedStatement.setString(1, dateFormat.format(startDate));
	    		preparedStatement.setString(2, dateFormat.format(endDate));
	    		System.out.println(preparedStatement);
	    		
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		// Process Result
	    		int i = 0;
	    		while(rs.next()) {
	    			int dishId = Integer.parseInt(rs.getString("dish_id"));
	    			dishIds[i++] = dishId;
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return dishIds;
	}
	
	public float getRevenueTotal(Date startDate, Date endDate, int dishId) {
		float total = 0;
		try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(GET_DISH_REVENUE_TOTAL);) {
    		// DATE FORMAT
    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		preparedStatement.setString(1, dateFormat.format(startDate));
    		preparedStatement.setString(2, dateFormat.format(endDate));
    		preparedStatement.setInt(3, dishId);
    		System.out.println(preparedStatement);
    		
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
    		while(rs.next()) {
    			total = rs.getFloat("SUM(`order_price`)");
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public float getReservationBill(int reservationId) {
		float total = 0;
		try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(GET_RESERVATION_BILL);) {
    		preparedStatement.setInt(1, reservationId);
    		System.out.println(preparedStatement);
    		
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
    		while(rs.next()) {
    			total = rs.getFloat("SUM(`order_price`)");
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public List<Order> getOrdersByRevenue(String startDate, String endDate, int dishById) throws ParseException {
		List<Order> orders = new ArrayList<>();
		try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_REVENUE);) {
    		preparedStatement.setString(1, startDate);
    		preparedStatement.setString(2, endDate);
    		preparedStatement.setInt(3, dishById);
    		System.out.println(startDate);
    		System.out.println(endDate);
    		System.out.println(dishById);
    		System.out.println(preparedStatement);
    		
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
    		while(rs.next()) {
    			int orderId = rs.getInt("order_id");
    			int reservationId = rs.getInt("reservation_id");
    			int dishId = rs.getInt("dish_id");
    			int dishQuantity = rs.getInt("dish_quantity");
    			float orderPrice = rs.getInt("order_price");
    			String orderedAt = rs.getString("ordered_at");
    			Date orderedOn = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("order_reg_date"));
    			orders.add(new Order(orderId, reservationId, dishId, dishQuantity, orderPrice, orderedAt, orderedOn));
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
	public List<Order> getOrdersByReservationId(int reservationById) throws ParseException {
		List<Order> orders = new ArrayList<>();
		try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_RESERVATION_ID);) {
    		preparedStatement.setInt(1, reservationById);
    		
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
    		while(rs.next()) {
    			int orderId = rs.getInt("order_id");
    			int reservationId = rs.getInt("reservation_id");
    			int dishId = rs.getInt("dish_id");
    			Dish dish = new DishDao().getDishById(dishId);
    			int dishQuantity = rs.getInt("dish_quantity");
    			float orderPrice = rs.getFloat("order_price");
    			String orderedAt = rs.getString("ordered_at");
    			Date orderedOn = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("order_reg_date"));
    			orders.add(new Order(orderId, reservationId, dishId, dishQuantity, orderPrice, orderedAt, orderedOn, dish));
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
}
