package model;

public class Table {
	private int tableId;
	private int maximumOfPeople;
	private String tableImage;
	private int nearWindow;
	private float tablePrice;
	
	public Table() {}
	
	public Table(int tableId, int maximumOfPeople, String tableImage, int nearWindow, float tablePrice) {
		super();
		this.tableId = tableId;
		this.maximumOfPeople = maximumOfPeople;
		this.tableImage = tableImage;
		this.nearWindow = nearWindow;
		this.tablePrice = tablePrice;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getMaximumOfPeople() {
		return maximumOfPeople;
	}

	public void setMaximumOfPeople(int maximumOfPeople) {
		this.maximumOfPeople = maximumOfPeople;
	}

	public String getTableImage() {
		return tableImage;
	}

	public void setTableImage(String tableImage) {
		this.tableImage = tableImage;
	}

	public int getNearWindow() {
		return nearWindow;
	}

	public void setNearWindow(int nearWindow) {
		this.nearWindow = nearWindow;
	}

	public float getTablePrice() {
		return tablePrice;
	}

	public void setTablePrice(float tablePrice) {
		this.tablePrice = tablePrice;
	}
	
}
