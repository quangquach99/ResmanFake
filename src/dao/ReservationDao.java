package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Reservation;

public class ReservationDao extends Dao {
	private static final String INSERT_NEW_RESERVATION = "INSERT INTO `reservation`"
			+ "(`table_id`,`number_of_people`,`customer_fullname`,`customer_email`,`customer_address`,`customer_phone`,`reservation_date`,`reservation_time`)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String CHECK_RESERVATION_BEFORE_INSERT = "SELECT * FROM `reservation` WHERE `table_id` = ? AND `reservation_date` = ? "
			+ "AND `reservation_time` = ?";
	private static final String GET_RESERVATION_BY_PHONE = "SELECT * FROM `reservation`, `table` WHERE `reservation`.`table_id` = `table`.`table_id` "
			+ "AND `customer_phone` = ? AND DATE(`reservation_date`) >= DATE(NOW());";
	private static final String GET_RESERVATION_BY_ID = "SELECT * FROM `reservation`,`table` WHERE `reservation_id` = ? AND `reservation`.`table_id` = `table`.`table_id`;";
	
	public ReservationDao() {}
	
	//INSERT a new reservation
	public boolean insertNewReservation(Reservation reservation) {
    	boolean result = false;
    	try (Connection connection = getConnection();
    		// Query
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_RESERVATION);) {
    		preparedStatement.setInt(1, reservation.getTableId());
    		preparedStatement.setInt(2, reservation.getNumberOfPeople());
    		preparedStatement.setString(3, reservation.getCustomerFullname());
    		preparedStatement.setString(4, reservation.getCustomerEmail());
    		preparedStatement.setString(5, reservation.getCustomerAddress());
    		preparedStatement.setString(6, reservation.getCustomerPhone());
    		// DATE FORMAT
    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		preparedStatement.setString(7, dateFormat.format(reservation.getReservationDate()));
    		preparedStatement.setString(8, reservation.getReservationTime());
    		System.out.println(preparedStatement);
    		//Execute the query
    		if(checkReservationBeforeInsert(reservation)) {
    			preparedStatement.executeUpdate();
        		result = true;
    		}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
	
	// CHECK if reservation is available before insert into db
	private boolean checkReservationBeforeInsert(Reservation reservation) {
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(CHECK_RESERVATION_BEFORE_INSERT);) {
	    		preparedStatement.setInt(1, reservation.getTableId());
	    		// DATE FORMAT
	    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    		preparedStatement.setString(2, dateFormat.format(reservation.getReservationDate()));
	    		preparedStatement.setString(3, reservation.getReservationTime());
	    		System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		if (rs.next() == false) {
	    	        return true;
	    	    } else {
	    	    	return false;
	    	    }
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	// GET Reservation By Phone
	public List<Reservation> getReservationsByPhone(String customerPhoneNumber) throws ParseException {
		List<Reservation> reservations = new ArrayList<>();
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_RESERVATION_BY_PHONE);) {
	    		preparedStatement.setString(1, customerPhoneNumber);
	    		System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		//Process the result
	    		while(rs.next()) {
	    			int reservationId = Integer.parseInt(rs.getString("reservation_id"));
	    			int tableId = Integer.parseInt(rs.getString("table_id"));
	    			String tableImage = rs.getString("table_image");
	    			int numberOfPeople = Integer.parseInt(rs.getString("number_of_people"));
	    			String customerFullname = rs.getString("customer_fullname");
	    			String customerEmail = rs.getString("customer_email");
	    			String customerAddress = rs.getString("customer_address");
	    			String customerPhone = rs.getString("customer_phone");
	    			Date reservationDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("reservation_date"));
	    			String reservationTime = rs.getString("reservation_time");
	    			Reservation reservation = new Reservation(reservationId,tableId,tableImage,numberOfPeople,customerFullname,customerEmail,customerAddress,customerPhone,reservationDate,reservationTime);
	    			reservations.add(reservation);
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return reservations;
	}
	
	// GET Reservation By Id
	public Reservation getReservationById(int reservationById) throws ParseException {
		Reservation reservation = null;
		try (Connection connection = getConnection();
	    		// Query
	    		PreparedStatement preparedStatement = connection.prepareStatement(GET_RESERVATION_BY_ID);) {
	    		preparedStatement.setInt(1, reservationById);

	    		System.out.println(preparedStatement);
	    		//Execute the query
	    		ResultSet rs = preparedStatement.executeQuery();
	    		while(rs.next()) {
	    			int reservationId = Integer.parseInt(rs.getString("reservation_id"));
	    			int tableId = Integer.parseInt(rs.getString("table_id"));
	    			String tableImage = rs.getString("table_image");
	    			int numberOfPeople = Integer.parseInt(rs.getString("number_of_people"));
	    			String customerFullname = rs.getString("customer_fullname");
	    			String customerEmail = rs.getString("customer_email");
	    			String customerAddress = rs.getString("customer_address");
	    			String customerPhone = rs.getString("customer_phone");
	    			Date reservationDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("reservation_date"));
	    			String reservationTime = rs.getString("reservation_time");
	    			reservation = new Reservation(reservationId,tableId,tableImage,numberOfPeople,customerFullname,customerEmail,customerAddress,customerPhone,reservationDate,reservationTime);
	    		}
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return reservation;
	}
}