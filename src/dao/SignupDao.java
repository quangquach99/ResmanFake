//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import model.CustomerModel;
//
//public class SignupDao {
//
//    public void newCustomer(CustomerModel customer) throws ClassNotFoundException {
//
//        Class.forName("com.mysql.jdbc.Driver");
//
//        try (Connection connection = DriverManager
//            .getConnection("jdbc:mysql://localhost:3306/restaurant?useSSL=false", "root", "dinhquang");
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection
//            .prepareStatement("INSERT INTO `customers`(`customer_firstname`,`customer_lastname`,`customer_email`,`customer_password`,`customer_address`,`customer_phone`) VALUES(?,?,?,?,?,?)")) {
//            preparedStatement.setString(1, customer.getCustomer_firstname());
//            preparedStatement.setString(2, customer.getCustomer_lastname());
//            preparedStatement.setString(3, customer.getCustomer_email());
//            preparedStatement.setString(4, customer.getCustomer_password());
//            preparedStatement.setString(5, customer.getCustomer_address());
//            preparedStatement.setString(6, customer.getCustomer_phone());
//
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
//        return;
//    }
//
//    private void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//    
//    public String selectCustomerByEmail(String email) throws ClassNotFoundException {
//    	Class.forName("com.mysql.jdbc.Driver");
//    	String result = "";
//        try (Connection connection = DriverManager
//            .getConnection("jdbc:mysql://localhost:3306/restaurant?useSSL=false", "root", "dinhquang");
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection
//            .prepareStatement("SELECT * FROM `customers` WHERE `customer_email` = ?")) {
//            preparedStatement.setString(1, email);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//        	while (rs.next()) {
//            	result = rs.getString("customer_email");
//            	break;
//            }
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
//        return result;
//    }
//}