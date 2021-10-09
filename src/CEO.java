
public class CEO extends Staff {
	private float shares=0;
	private static int numOfCEO =0;
	public CEO(String iD, String name, String phoneNumber, int workDays) {
		super(iD, name, phoneNumber, workDays, 300);
		
		numOfCEO++;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public CEO(String iD, String name, String phoneNumber, int workDays, float shares) {
		super(iD, name, phoneNumber, workDays, 300);
		this.shares = shares;
		numOfCEO++;
	}




	public float getShares() {
		return shares;
	}



	
	  public void setShares(float shares) {
	  
	  this.shares= shares; 
	  }
	 

	  

	public static int getNumOfCEO() {
		return numOfCEO;
	}


	@Override
	public double CalculateSalary() {
		
		return this.dailyWage* this.workDays;
	}




	@Override
	public String toString() {
		return "CEO [shares=" + shares + ", ID=" + ID + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", workDays=" + workDays + ", dailyWage=" + dailyWage +  "]";
	}
	
	
	
}
