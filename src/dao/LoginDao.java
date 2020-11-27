package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Manager;

public class LoginDao extends Dao {
	private static final String VALIDATE_MANAGER = "SELECT * FROM `manager` WHERE `manager_email` = ?";
	
	// GET manager by email
	public Manager validateManager(Manager manager) {
		Manager result = null;
		try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_MANAGER);) {
			preparedStatement.setString(1, manager.getUserEmail());
			System.out.println(preparedStatement);
    		//Execute the query
    		ResultSet rs = preparedStatement.executeQuery();
    		// Process Result
			while(rs.next()) {
    			int managerId = Integer.parseInt(rs.getString("manager_id"));
    			String managerFullname = rs.getString("manager_fullname");
    			String managerEmail = rs.getString("manager_email");
    			String managerPassword = rs.getString("manager_password");
    			String managerAddress = rs.getString("manager_address");
    			String managerPhone = rs.getString("manager_phone");
    			
    			result = new Manager(managerId,managerFullname,managerEmail,managerPassword,managerAddress,managerPhone);
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return result;
	}
}
