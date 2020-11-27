package model;

import java.util.Date;

public class Reservation {
	private int reservationId;
	private int tableId;
	private String tableImage;
	private int numberOfPeople;
	private String customerFullname;
	private String customerEmail;
	private String customerAddress;
	private String customerPhone;
	private Date reservationDate;
	private String reservationTime;
	
	public Reservation() {}
	
	public Reservation(
			int tableId, int numberOfPeople, String customerFullname, String customerEmail, String customerAddress, String customerPhone, Date bookingDate, String bookingTime) {
		super();
		this.tableId = tableId;
		this.numberOfPeople = numberOfPeople;
		this.customerFullname = customerFullname;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.reservationDate = bookingDate;
		this.reservationTime = bookingTime;
	}
	public Reservation(
			int reservationId, int tableId, String tableImage, int numberOfPeople, String customerFullname, String customerEmail, String customerAddress, String customerPhone, Date bookingDate, String bookingTime) {
		super();
		this.reservationId = reservationId;
		this.tableId = tableId;
		this.tableImage = tableImage;
		this.numberOfPeople = numberOfPeople;
		this.customerFullname = customerFullname;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.reservationDate = bookingDate;
		this.reservationTime = bookingTime;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableImage() {
		return tableImage;
	}
	public void setTableImage(String tableImage) {
		this.tableImage = tableImage;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getCustomerFullname() {
		return customerFullname;
	}
	public void setCustomerFullname(String customerFullname) {
		this.customerFullname = customerFullname;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
}
