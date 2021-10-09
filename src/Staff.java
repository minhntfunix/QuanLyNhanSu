
public abstract class Staff {
	protected String ID;
	protected String name;
	protected String phoneNumber;
	protected int workDays;
	protected double dailyWage;
	protected static int numOfEmployees =0;
	
	
	
	
	
	
	
	public Staff(String iD, String name, String phoneNumber, int workDays, double dailyWage) {
		super();
		ID = iD;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.workDays = workDays;
		this.dailyWage = dailyWage;
		numOfEmployees ++;
	}



	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getWorkDays() {
		return workDays;
	}
	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}
	public double getDailyWage() {
		return dailyWage;
	}
	public void setDailyWage(double dailyWage) {
		this.dailyWage = dailyWage;
	}
	public static int getNumOfEmployees() {
		return numOfEmployees;
	}
	
	
	public abstract double CalculateSalary() ;



	@Override
	public String toString() {
		return "Staff [ID=" + ID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", workDays=" + workDays
				+ ", dailyWage=" + dailyWage +  "]";
	}



	
	
	
	
}
