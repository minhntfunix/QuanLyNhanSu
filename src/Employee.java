
public class Employee extends Staff {
	Manager manager=null;
	private static int numOfEmployee = 0;
	

	public Employee(String iD, String name, String phoneNumber, int workDays) {
		super(iD, name, phoneNumber, workDays, 100);		
		numOfEmployee ++;
		
	}

	public Employee(String iD, String name, String phoneNumber, int workDays, Manager manager) {
		super(iD, name, phoneNumber, workDays, 100);	
		this.manager= manager;
		numOfEmployee ++;
		
	}
	
	
	public Manager getManager() {
		return manager;
	}




	public void setManager(Manager manager) {
		this.manager = manager;
	}

	


	public static int getNumOfEmployee() {
		return numOfEmployee;
	}



	@Override
	public double CalculateSalary() {
		double Salary= this.dailyWage * workDays;
		return Salary;
		
	}

	@Override
	public String toString() {
		return "Employee [manager=" + manager + ", ID=" + ID + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", workDays=" + workDays + ", dailyWage=" + dailyWage + "]";
	}

	
	
	
	
	
}
