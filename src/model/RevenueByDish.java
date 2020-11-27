package model;

import java.util.Date;

public class RevenueByDish {
	private Date revenueFrom;
	private Date revenueTo;
	private float revenueTotal;
	private Dish particularDish;
	
	public RevenueByDish() {}
	
	public RevenueByDish(int dishId, Date revenueFrom, Date revenueTo) {
		super();
		this.revenueFrom = revenueFrom;
		this.revenueTo = revenueTo;
		this.particularDish.setDishId(dishId);
	}

	public RevenueByDish(Date revenueFrom, Date revenueTo, float revenueTotal, Dish particularDish) {
		super();
		this.revenueFrom = revenueFrom;
		this.revenueTo = revenueTo;
		this.revenueTotal = revenueTotal;
		this.particularDish = particularDish;
	}

	public Date getRevenueFrom() {
		return revenueFrom;
	}

	public void setRevenueFrom(Date revenueFrom) {
		this.revenueFrom = revenueFrom;
	}

	public Date getRevenueTo() {
		return revenueTo;
	}

	public void setRevenueTo(Date revenueTo) {
		this.revenueTo = revenueTo;
	}

	public float getRevenueTotal() {
		return revenueTotal;
	}

	public void setRevenueTotal(float revenueTotal) {
		this.revenueTotal = revenueTotal;
	}

	public Dish getParticularDish() {
		return particularDish;
	}

	public void setParticularDish(Dish particularDish) {
		this.particularDish = particularDish;
	}
}
