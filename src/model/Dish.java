package model;

public class Dish {
	private int dishId;
	private String dishName;
	private String dishImage;
	private int dishType;
	private float dishPrice;
	
	public Dish() {}
	
	public Dish(int dishId, String dishName, String dishImage, int dishType, float dishPrice) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishImage = dishImage;
		this.dishType = dishType;
		this.dishPrice = dishPrice;
	}

	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishImage() {
		return dishImage;
	}
	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}
	public int getDishType() {
		return dishType;
	}
	public void setDishType(int dishType) {
		this.dishType = dishType;
	}
	public float getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(float dishPrice) {
		this.dishPrice = dishPrice;
	}
}
