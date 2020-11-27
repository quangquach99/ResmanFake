package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Table;

public class TableDao extends Dao {
    private static final String GET_AVAILABLE_TABLES = "SELECT * FROM `table` WHERE `maximum_of_people` >= ? AND `table_id` NOT IN" + 
    		"(SELECT `table_id` FROM `reservation` WHERE `reservation_date` = ? AND `reservation_time` = ?)";
    private static final String GET_TABLE_BY_ID = "SELECT * FROM `table` WHERE `table_id` = ?";
    
    public TableDao() {}
    
    public List<Table> selectAvailableTables(int numberOfPeople, String reservationDate, String reservationTime) {
    	List<Table> tables = new ArrayList < >();
    	
    	try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(GET_AVAILABLE_TABLES);) {
    		preparedStatement.setInt(1, numberOfPeople);
    		preparedStatement.setString(2, reservationDate);
    		preparedStatement.setString(3, reservationTime);
    		System.out.println(preparedStatement);
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
    		while(rs.next()) {
    			int tableID = rs.getInt("table_id");
    			int maximumOfPeople = rs.getInt("maximum_of_people");
    			String tableImage = rs.getString("table_image");
    			int nearWindow = rs.getInt("near_window");
    			float tablePrice = rs.getFloat("table_price");
    			tables.add(new Table(tableID, maximumOfPeople, tableImage, nearWindow, tablePrice));
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return tables;
    }
    
    public Table getTableById(int tableId) {
    	Table table = null;
    	
    	try (Connection connection = getConnection();
        		// Query
        		PreparedStatement preparedStatement = connection.prepareStatement(GET_TABLE_BY_ID);) {
        		preparedStatement.setInt(1, tableId);
        		System.out.println(preparedStatement);
        		//Execute the query
        		ResultSet rs = preparedStatement.executeQuery();
        		// Process Result
        		while(rs.next()) {
        			int tableID = rs.getInt("table_id");
        			int maximumOfPeople = rs.getInt("maximum_of_people");
        			String tableImage = rs.getString("table_image");
        			int nearWindow = rs.getInt("near_window");
        			float tablePrice = rs.getFloat("table_price");
        			table = new Table(tableID, maximumOfPeople, tableImage, nearWindow, tablePrice);
        		}
        	} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	return table;
    }
}