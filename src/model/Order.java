package model;

import java.util.Date;

public class Order {
	private int orderId;
	private int reservationId;
	private int dishId;
	private int dishQuantity;
	private float dishPrice;
	private float orderPrice;
	private String orderedAt;
	private Date orderedOn;
	private Dish particularDish;
	
	public Order() {}
	
	public Order(int reservationId, int dishId, int dishQuantity, float dishPrice) {
		super();
		this.reservationId = reservationId;
		this.dishId = dishId;
		this.dishQuantity = dishQuantity;
		this.dishPrice = dishPrice;
		this.orderPrice = this.getDishPrice() * this.getDishQuantity();
	}
	
	public Order(int orderId, int reservationId, int dishId, int dishQuantity, float orderPrice, String orderedAt,
			Date orderedOn) {
		super();
		this.orderId = orderId;
		this.reservationId = reservationId;
		this.dishId = dishId;
		this.dishQuantity = dishQuantity;
		this.orderPrice = orderPrice;
		this.orderedAt = orderedAt;
		this.orderedOn = orderedOn;
	}
	
	public Order(int orderId, int reservationId, int dishId, int dishQuantity, float orderPrice, String orderedAt,
			Date orderedOn, Dish particularDish) {
		super();
		this.orderId = orderId;
		this.reservationId = reservationId;
		this.dishId = dishId;
		this.dishQuantity = dishQuantity;
		this.orderPrice = orderPrice;
		this.orderedAt = orderedAt;
		this.orderedOn = orderedOn;
		this.particularDish = particularDish;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public int getDishQuantity() {
		return dishQuantity;
	}
	public void setDishQuantity(int dishQuantity) {
		this.dishQuantity = dishQuantity;
	}
	public float getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(float dishPrice) {
		this.dishPrice = dishPrice;
	}
	public float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderedAt() {
		return orderedAt;
	}
	public void setOrderedAt(String orderedAt) {
		this.orderedAt = orderedAt;
	}
	public Date getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}
	public Dish getParticularDish() {
		return particularDish;
	}
	public void setParticularDish(Dish particularDish) {
		this.particularDish = particularDish;
	}
}
