import java.util.ArrayList;

public class Manager extends Staff {
	private ArrayList<Employee> ls;
	private static int numOfManager=0;
	public Manager(String iD, String name, String phoneNumber, int workDays) {
		super(iD, name, phoneNumber, workDays, 200);
		numOfManager++;
	}
	
	
	
	
	
	
	public Manager(String iD, String name, String phoneNumber, int workDays, double dailyWage, ArrayList<Employee> ls) {
		super(iD, name, phoneNumber, workDays, dailyWage);
		this.ls = ls;
	}






	public ArrayList<Employee> getLs() {
		return ls;
	}

	public void setLs(ArrayList<Employee> ls) {
		this.ls = ls;
	}

	

	public static int getNumOfManager() {
		return numOfManager;
	}



	



	@Override
	public double CalculateSalary() {
		if (this.getLs()==null) {
			return  this.dailyWage * workDays;
		}else {
		return this.dailyWage * workDays + 100* this.getLs().size();
		
		}
	}



	@Override
	public String toString() {
		return "Manager [ID=" + ID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", workDays=" + workDays
				+ ", dailyWage=" + dailyWage + "]";
	}



	
	
	
	
	

}
