package model;

public class Manager extends User {
	private int managerId;

	public Manager() {}
	
	public Manager(String managerEmail) {
		super();
		this.setUserEmail(managerEmail);
	}
	
	public Manager(int managerId, String managerFullname, String managerEmail, String managerPassword, String managerAddress, String managerPhone) {
		super();
		this.managerId = managerId;
		this.setUserFullName(managerFullname);
		this.setUserEmail(managerEmail);
		this.setUserPassword(managerPassword);
		this.setUserAddress(managerAddress);
		this.setUserPhone(managerPhone);
	}
	
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
