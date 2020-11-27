package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	protected Connection getConnection() {
        Connection connection = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resman?useSSL=false", "root", "dinhquang");
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
		return connection;
    }
}
