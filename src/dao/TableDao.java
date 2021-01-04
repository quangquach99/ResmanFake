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
    // LE MANH QUANG
    //Add table
    
    private static final String INSERT_TABLE_SQL = "INSERT INTO `table`" + "  (maximum_of_people, table_image, near_window, table_price)  " +
            "VALUES (?, ?, ?, ?);";
    //private static final String SELECT_TABLE_BY_ID = "select table_id,maximum_of_people, table_image, near_window, table_price from `table` where table_id =?";
    private static final String SELECT_ALL_TABLE = "select * from `table`";
    private static final String DELETE_TABLE_SQL = "delete from `table` where table_id = ?;";
    private static final String UPDATE_TABLE_SQL = "update `table` set maximum_of_people = ?,table_image= ?, near_window =?, table_price =? where table_id = ?;";
    
    
    
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
    
    // LE MANH QUANG
//  Add table
   public void insertTable(Table table) throws SQLException {
       System.out.println(INSERT_TABLE_SQL);
       // try-with-resource statement will auto close the connection.
       try (Connection connection = getConnection();
       	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TABLE_SQL)) {
           preparedStatement.setInt(1, table.getMaximumOfPeople());
           preparedStatement.setString(2, table.getTableImage());
           preparedStatement.setInt(3, table.getNearWindow());
           preparedStatement.setFloat(4, table.getTablePrice());
           System.out.println(preparedStatement);
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
       	e.printStackTrace();
       }
       
   }

   public Table selectTable(int tableId) {
   	Table table = null;
       // Step 1: Establishing a Connection
       try (Connection connection = getConnection();
           // Step 2:Create a statement using connection object
           PreparedStatement preparedStatement = connection.prepareStatement(GET_TABLE_BY_ID);) {
           preparedStatement.setInt(1, tableId);
           System.out.println(preparedStatement);
           // Step 3: Execute the query or update query
           ResultSet rs = preparedStatement.executeQuery();

           // Step 4: Process the ResultSet object.
           while(rs.next()) {  			
   			int maximumOfPeople = rs.getInt("maximum_of_people");
   			String tableImage = rs.getString("table_image");
   			int nearWindow = rs.getInt("near_window");
   			float tablePrice = rs.getFloat("table_price");
   			table = new Table(tableId, maximumOfPeople, tableImage, nearWindow, tablePrice);
   		}
   	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return table;
   }

   public List < Table > selectAllTables() {

       // using try-with-resources to avoid closing resources (boiler plate code)
       List < Table > table = new ArrayList < > ();
       // Step 1: Establishing a Connection
       try (Connection connection = getConnection();

           // Step 2:Create a statement using connection object
           PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TABLE);) {
           System.out.println(preparedStatement);
           // Step 3: Execute the query or update query
           ResultSet rs = preparedStatement.executeQuery();

           // Step 4: Process the ResultSet object.
           while(rs.next()) {
   			int tableID = rs.getInt("table_id");
   			int maximumOfPeople = rs.getInt("maximum_of_people");
   			String tableImage = rs.getString("table_image");
   			int nearWindow = rs.getInt("near_window");
   			float tablePrice = rs.getFloat("table_price");
   			table.add(new Table(tableID, maximumOfPeople, tableImage, nearWindow, tablePrice));
   		}
   	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return table;
   }

   public boolean deleteTable(int tableId) throws SQLException {
       boolean rowDeleted;
       try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TABLE_SQL);) {
           statement.setInt(1, tableId);
           rowDeleted = statement.executeUpdate() > 0;
       }
       return rowDeleted;
   }

   public boolean updateTable(Table table) throws SQLException {
       boolean rowUpdated;
       try (Connection connection = getConnection(); 
       	PreparedStatement statement = connection.prepareStatement(UPDATE_TABLE_SQL);) {
       	statement.setInt(1, table.getMaximumOfPeople());
       	statement.setString(2, table.getTableImage());
           statement.setInt(3, table.getNearWindow());
           statement.setFloat(4, table.getTablePrice());
           statement.setInt(5, table.getTableId());
           rowUpdated = statement.executeUpdate() > 0;
       }
       return rowUpdated;
   }
}