package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dish;

public class DishDao extends Dao {
	private static final String GET_DISH_BY_ID = "SELECT * FROM `dish` WHERE `dish_id` = ?;";
	private static final String GET_ALL_DISHES = "SELECT * FROM `dish`";
	private static final String GET_DISHES_BY_NAME = "SELECT * FROM `dish` WHERE `dish_name` LIKE ?;";
	private static final String GET_DISHES_BY_TYPE = "SELECT * FROM `dish` WHERE `dish_type` = ?;";
	private static final String GET_DISHES_BY_NAME_AND_TYPE = "SELECT * FROM `dish` WHERE `dish_name` LIKE ? AND `dish_type` = ?;";
	
	// NGUYEN VAN HOANG
	private static final String INSET_INTO_DISH = "INSERT INTO `dish`(`dish_name`,  `dish_type`, `dish_price`) VALUES(?,?,?)";
	private static final String UPDATE_DISH="UPDATE 'dish' SET 'dish_name'=?,  `dish_type`=?, `dish_price`=? WHERE `dish_id`=? ";
	private static final String DELETE_DISH="DELETE FROM 'dish' WHERE 'dish_id'=? ";
	
	public DishDao() {}
	
	// GET dish by Id
	public Dish getDishById(int dishById) {
		Dish dish = null;
		
		try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(GET_DISH_BY_ID);) {
			preparedStatement.setInt(1, dishById);
    		System.out.println(preparedStatement);
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
    		while(rs.next()) {
    			int dishId = Integer.parseInt(rs.getString("dish_id"));
    			String dishName = rs.getString("dish_name");
    			String dishImage = rs.getString("dish_image");
    			int dishType = Integer.parseInt(rs.getString("dish_type"));
    			float dishPrice = Float.parseFloat(rs.getString("dish_price"));
    			dish = new Dish(dishId, dishName, dishImage, dishType, dishPrice);
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return dish;
	}
	
	// GET all dishes
	public List<Dish> getAllDish() {
		List<Dish> dishes = new ArrayList<>();
		
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DISHES);) {
	    		System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		// Process Result
	    		while(rs.next()) {
	    			int dishId = Integer.parseInt(rs.getString("dish_id"));
	    			String dishName = rs.getString("dish_name");
	    			String dishImage = rs.getString("dish_image");
	    			int dishType = Integer.parseInt(rs.getString("dish_type"));
	    			float dishPrice = Float.parseFloat(rs.getString("dish_price"));
	    			dishes.add(new Dish(dishId,dishName,dishImage,dishType,dishPrice));
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return dishes;
	}
	// GET dishes by name
	public List<Dish> getDishesByName(String dishname) {
		List<Dish> dishes = new ArrayList<>();
		
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_DISHES_BY_NAME);) {
	    		preparedStatement.setString(1, '%' + dishname + '%');
				System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		// Process Result
	    		while(rs.next()) {
	    			int dishId = Integer.parseInt(rs.getString("dish_id"));
	    			String dishName = rs.getString("dish_name");
	    			String dishImage = rs.getString("dish_image");
	    			int dishType = Integer.parseInt(rs.getString("dish_type"));
	    			float dishPrice = Float.parseFloat(rs.getString("dish_price"));
	    			dishes.add(new Dish(dishId,dishName,dishImage,dishType,dishPrice));
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return dishes;
	}
	
	// GET dishes by type
	public List<Dish> getDishesByType(int dishtype) {
		List<Dish> dishes = new ArrayList<>();
		
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_DISHES_BY_TYPE);) {
	    		preparedStatement.setInt(1, dishtype);
				System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		// Process Result
	    		while(rs.next()) {
	    			int dishId = Integer.parseInt(rs.getString("dish_id"));
	    			String dishName = rs.getString("dish_name");
	    			String dishImage = rs.getString("dish_image");
	    			int dishType = Integer.parseInt(rs.getString("dish_type"));
	    			float dishPrice = Float.parseFloat(rs.getString("dish_price"));
	    			dishes.add(new Dish(dishId,dishName,dishImage,dishType,dishPrice));
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return dishes;
	}
	
	// GET dishes by name and type
	public List<Dish> getDishesByNameAndType(String dishname, int dishtype) {
		List<Dish> dishes = new ArrayList<>();
		
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_DISHES_BY_NAME_AND_TYPE);) {
	    		preparedStatement.setString(1, '%' + dishname + '%');
	    		preparedStatement.setInt(2, dishtype);
				System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		// Process Result
	    		while(rs.next()) {
	    			int dishId = Integer.parseInt(rs.getString("dish_id"));
	    			String dishName = rs.getString("dish_name");
	    			String dishImage = rs.getString("dish_image");
	    			int dishType = Integer.parseInt(rs.getString("dish_type"));
	    			float dishPrice = Float.parseFloat(rs.getString("dish_price"));
	    			dishes.add(new Dish(dishId,dishName,dishImage,dishType,dishPrice));
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return dishes;
	}
	
	// NGUYEN VAN HOANG
	public boolean insertDish(Dish dish) {
    	try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(INSET_INTO_DISH);) {
    		preparedStatement.setString(1, dish.getDishName());
    		preparedStatement.setInt(2, dish.getDishType());
    		preparedStatement.setFloat(3, dish.getDishPrice());
    		preparedStatement.setString(4,"hieu.jpg");
    		int a=preparedStatement.executeUpdate();
    		if(a>0)
    			return true;
    		else
    			return false;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
	
	public List<Dish> findAll(){
		List<Dish> books = new ArrayList<Dish>();
		try {
			String hqlString ="select * from dish";
			 Dao connectDAO = new Dao();
			 Connection connection = connectDAO.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(hqlString);
			
			 ResultSet resultSet = preparedStatement.executeQuery();
			  while (resultSet.next()) {
	               Dish dish = new Dish();
	               dish.setDishId(resultSet.getInt("dish_id"));
	               dish.setDishType(resultSet.getInt("dish_type"));
	               dish.setDishPrice(resultSet.getFloat("dish_price"));
	               dish.setDishName(resultSet.getString("dish_name"));
	               dish.setDishImage(resultSet.getString("dish_image"));
	             
	               books.add(dish);
	            }
			  
			  return books;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public boolean updateDish(Dish dish) {
		try (Connection connection=getConnection();
				//Query
				PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_DISH);){
			preparedStatement.setString(1,dish.getDishName());
			preparedStatement.setInt(2,dish.getDishType());
			preparedStatement.setFloat(3,dish.getDishPrice());
			preparedStatement.setInt(4,dish.getDishId());
			
			preparedStatement.executeUpdate();
			int a=preparedStatement.executeUpdate();
    		if(a>0)
    			return true;
    		else
    			return false;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
	public void deledteDish(int id) {
		try(Connection connection=getConnection();
				//Query
				PreparedStatement preparedStatement=connection.prepareStatement(DELETE_DISH);){
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
