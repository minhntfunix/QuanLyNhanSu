import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
	public static ArrayList <Staff> ls= new ArrayList <Staff>(); 
	
	public static void main(String[] args) {
		
		Scanner input= new Scanner (System.in);
		Company c1= new Company ();
		
		c1.setLs(ls);
		int choose=-1;
		do
		{
			ShowMenu();				  
			
			System.out.print("Please choose a number: ");
			  
			while (!input.hasNextInt()) {
				System.out.print("Don't choose string, enter again: "); 
				input.nextLine(); 
			}
			 
			
			/*
			 * do { System.out.print("Please choose a number: "); if (input.hasNextInt()) {
			 * choose= input.nextInt(); break; }else {
			 * System.out.print("Don't input string.Enter again: "); input.nextLine();
			 * 
			 * 
			 * }
			 * 
			 * 
			 * }while (!input.hasNextInt());
			 */
			
			
			choose=input.nextInt();
			
			switch (choose) {
				case 1:
					CreateCompany(c1);
					System.out.println(c1.toString());
					break;
				case 2:
					
					break;
				case 3:
					AddStaff(c1);
					break;
				case 4:
					DisplayStaff(c1);
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Please enter the correct number");
			}
			
		}while (choose!=8);
		
	}
	
	
	public static void  ShowMenu() {
		System.out.println("1. Nhập thông tin công ty"); 	
		System.out.println("2. Phân bổ Nhân viên vào Trưởng phòng"); 
		System.out.println("3. Thêm, xóa thông tin một nhân sự "); 	
		System.out.println("4. Xuất ra thông tin toàn bộ người trong công ty"); 
		System.out.println("5. Tính và xuất tổng lương cho toàn công ty"); 	
		System.out.println("6. Tìm Nhân viên thường có lương cao nhấ"); 
		System.out.println("7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất "); 	
		
	}
	
	public static void AddStaff(Company c) {
		if (c.getName().equals("")) {
			System.out.println("You have to create a company first. Exiting");
			return;
		}
		AddMenu();
		System.out.println("Please choose a number from 1 to 3: ");
		Scanner input= new Scanner (System.in);
		while (!input.hasNextInt()) { 
			System.out.print("Don't choose string, input number: ");
			input.nextLine();
			  
		}
		int choose=input.nextInt();
		input.nextLine();
		
		/*
		 * protected String ID; protected String name; protected String phoneNumber;
		 * protected int workDays; 
		 */
		
		System.out.print("Please enter ID: ");
		String ID= input.nextLine();
		
		System.out.print("Please enter name: ");
		String name= input.nextLine();

		System.out.print("Please enter phoneNum: ");
		String phoneNum= input.nextLine();
		
		System.out.println("Please enter number of workDays: ");
		while(!input.hasNextInt()) {
			System.out.println("Please enter the number format:");
			input.nextLine();
		}
		int workDays= input.nextInt();
		input.nextLine();		
		
		
		switch (choose) {
		case 1:
			
			c.getLs().add( new Employee(ID,name,phoneNum,workDays) );
			
			break;
		case 2:
			c.getLs().add(new Manager(ID,name,phoneNum,workDays));
			break;
		case 3:					
			
			System.out.println("How much shares does the CEO holds?: ");
			
			while (!input.hasNextFloat()) {
				System.out.print("Don't choose string, enter again: "); 
				input.nextLine(); 
				
			}
			float shares=input.nextFloat();
			while (shares >100) {
				System.out.println("Shares must be less than 100. Enter Again: ");
				shares=input.nextFloat();				
				
			}		
			
			CEO ceo= new CEO(ID,name,phoneNum,workDays);
			ceo.setShares(shares);
			break;
		default:
			System.out.println("Please enter the correct number");
			break;
		}
		
	}
	
	public static void AddMenu() {
		System.out.println("1. Add Employee");
		System.out.println("2. Add Manager");
		System.out.println("3. Add CEO");
	}
	
	public static void CreateCompany(Company c) {
		System.out.println("Please enter the company name:");
		Scanner input= new Scanner (System.in);
		String s= input.nextLine();
		c.setName(s);
		System.out.println("Please enter the taxID:");
		
		String ID= input.nextLine();
		c.setTaxID(ID);
		System.out.println("Please enter the revenue:");
		
		while (!input.hasNextDouble()) {
			System.out.print("Don't choose string, enter again: "); 
			input.nextLine(); 
			
		}
		
		
		double revenue= input.nextDouble();
		c.setRevenue(revenue);
		
	}
	
	
	public static void DeleteStaff(Company c) {
		if (c.getName().equals("")) {
			System.out.println("You have to create a company first. Exiting");
			return;
		}
		System.out.println("Please enter the ID to delete");
		Scanner input= new Scanner (System.in);
		String s= input.nextLine();
		boolean x= false;
		for (Staff staff: c.getLs()) {
			if (staff.getID().equalsIgnoreCase(s)) {
				c.getLs().remove(staff);
				x= true;
			}
		}
		
		if (x==false) {
			System.out.println("There is no ID match");
			return;
		}
		
	} 
	
	public static void DisplayStaff(Company c) {
		if (c.getName().equals("")) {
			System.out.println("You have to create a company first. Exiting");
			return;
		}
		for (Staff staff: c.getLs()) {
			System.out.println(staff.toString());
		}
	}
	
	public static Employee AddEmployee(String ID,String name, String phoneNum,int workDays) {
		System.out.println("Do you want a manager to manage this employee? Y/N");
		Scanner input= new Scanner (System.in);
		String a= input.nextLine();
		if (a.equalsIgnoreCase("Yes") || a.equalsIgnoreCase("Y")) {
			
		}
		
		return new Employee(ID,name,phoneNum, workDays);
		
	}
	
	public static boolean IsManagerExist() {
		System.out.println("Please input ID or name of Manager");
		return false;
		
	}
	
}
