import java.util.ArrayList;

public class Company {
	private String name="";
	private String taxID="";
	private double revenue;
	private ArrayList<Staff> ls;
	
	
	
	public Company() {
		super();
	}

	public Company(String name, String taxID, double revenue) {
		super();
		this.name = name;
		this.taxID = taxID;
		this.revenue = revenue;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public ArrayList<Staff> getLs() {
		return ls;
	}
	
	
	

	public void setLs(ArrayList<Staff> ls) {
		this.ls = ls;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", taxID=" + taxID + ", "
				+ "revenue=" + revenue + "]";
	}

	

	
	
	
	
	
}
