import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	//danh sách NV tổng
	public static ArrayList <Staff> ls= new ArrayList <Staff>(); 
	
	//danh sách Manager
	public static ArrayList <Manager> mls= new ArrayList <Manager>();
	public static Company c= new Company();	
	
	public static void main(String[] args) {
		
		Scanner input= new Scanner (System.in);
		
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
					CreateCompany();
					System.out.println(c.toString());
					break;
				case 2:
					AddStaff();
					break;
				case 3:
					
					DeleteStaff();
					break;
				case 4:
					DisplayStaff();
					break;
				case 5:
					
					System.out.println("Total Salary is : " + TotalSalary());
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
		System.out.println("2. Thêm nhân sự"); 
		System.out.println("3. Xóa  nhân sự "); 	
		System.out.println("4. Xuất ra thông tin toàn bộ người trong công ty"); 
		System.out.println("5. Tính và xuất tổng lương cho toàn công ty"); 	
		System.out.println("6. Tìm Nhân viên thường có lương cao nhấ"); 
		System.out.println("7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất "); 	
		
	}
	
	
	//Thêm nhân viên
	public static void AddStaff() {
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
			//Thêm nhân viên vào ds tổng
			ls.add(AddEmployee(ID,name,phoneNum,workDays));
			System.out.println("New Employee added");
			break;
		case 2:
			
			//thêm manager vào ds tổng và ds Manager
			ls.add(new Manager(ID,name,phoneNum,workDays));
			mls.add(new Manager(ID,name,phoneNum,workDays));
			System.out.println("New Manager added");
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
			
			//thêm CEO vào ds tổng
			ls.add(new CEO(ID,name,phoneNum,workDays,shares));
			System.out.println("New CEO added");
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
	
	public static void CreateCompany() {
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
	
	
	public static void DeleteStaff() {
		if (c.getName().equals("")) {
			System.out.println("You have to create a company first. Exiting");
			return;
		}
		System.out.println("Please enter the ID or name to delete");
		
		Scanner input= new Scanner (System.in);
		String s= input.nextLine();
		boolean x= false;
		for (Staff staff: ls) {
			
			//so sánh phần tử trong ds tổng với name/ID cần xóa 
			if (staff.getID().equalsIgnoreCase(s) || staff.getName().equalsIgnoreCase(s)) {
				x=true;				
				
				//nếu ID/name cần xóa là Manager
				if (staff instanceof Manager) {
					
					//Duyệt qua ds tổng để tìm employee có name/ID Manager cần xóa
					for (Staff emp: ls) {
						if (emp instanceof Employee ) {
							if (((Employee) emp).getManager() != null) {
								if ( ((Employee) emp).getManager().getName().equalsIgnoreCase(s) 
									|| ((Employee) emp).getManager().getID().equalsIgnoreCase(s)  ) 
					
									{
										((Employee) emp).setManager(null);
										break;
									}
							}
						}
					}					
					//xóa khỏi Manager list
					mls.remove(staff);
					
					//xóa khỏi ds tổng
					ls.remove(staff);
					System.out.println("Manager with ID "+ s + " deleted" );
					break;
					
					//nếu ID/name cần xóa là Employee
					}else if (staff instanceof Employee){				
					
					//tìm manager trong ds Manager để xóa nhân viên do Manager đó quản lý
						for (Manager manager:mls) {
							if (((Employee) staff).getManager() !=null) {
								if ( ((Employee) staff).getManager().getName().equalsIgnoreCase(manager.getName())
										|| ((Employee) staff).getManager().getID().equalsIgnoreCase(manager.getID()) ) 
								{
										manager.getLs().remove(staff);	
										break;
								}
							}
						}
					
					//xóa nhân viên khỏi danh sách tổng
						ls.remove(staff);	
						break;
					}
					
					}
					
		}
					
		
		
		if (x==false) {
			System.out.println("There is no ID or name match");
			return;
		}
		
	} 
	public static void DeleteMenu() {
		System.out.println("1. Delete Employee");
		System.out.println("2. Delete Manager");
		System.out.println("3. Delete CEO");
	}
	public static void DisplayStaff() {
		if (ls.size()==0) {
			System.out.println("You have to create a company first. Exiting");
			return;
		}
		for (Staff staff: ls) {
			System.out.println(staff.toString());
		}
	}
	
	//hỏi user muốn có manager quản lý nhân viên này ko
	public static Employee AddEmployee(String ID,String name,String phoneNum,int workDays) {
		System.out.println("Do you want a manager to manage this employee? Y/N");
		Scanner input= new Scanner (System.in);
		String a= input.nextLine();
		boolean x=false;
		if (a.equalsIgnoreCase("Yes") || a.equalsIgnoreCase("Y")) {
			
			System.out.println("Please enter Manager ID or name: ");
			String mgr= input.nextLine();
			
			for (Manager manager:mls) {				
					if ( mgr.equalsIgnoreCase(manager.getName()) || mgr.equalsIgnoreCase(manager.getID()) ){
							
							Employee em= new Employee(ID,name,phoneNum, workDays, manager);	
							
							manager.setLs(new ArrayList<Employee>());
							manager.getLs().add(em);
							x=true;
							System.out.println("Manager for employee ID " + em.getID()+ " added");							
							return em;							
					}
			}
			
			
			if (x==false) {
				System.out.println("There is no such manager.Exiting");
				return null;
			}
						
		}else {
			System.out.println("No manager added for this employee");
			return new Employee(ID,name,phoneNum, workDays);		
			
			}
		return null;
	}
		
			
	
	

	
	
	
	
	public static boolean IsManagerExist(String mgr) {
		
		Scanner input= new Scanner (System.in);
		mgr= input.nextLine();
		
		for (Staff staff:ls) {
			if (staff instanceof Manager) {
				if ( mgr.equalsIgnoreCase(staff.getName()) || mgr.equalsIgnoreCase(staff.getID()) ){
					return true;
				}
			}
		}
		return false;
		
	}
	
	public static boolean IsEmployeeExist(String emp) {
		
		Scanner input= new Scanner (System.in);
		emp= input.nextLine();
		
		for (Staff staff:ls) {
			if (staff instanceof Employee) {
				if ( emp.equalsIgnoreCase(staff.getName()) || emp.equalsIgnoreCase(staff.getID()) ){
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	
	public static double TotalSalary() {
		double totalSalary=0;
		for (Staff staff: ls) {
			totalSalary+= staff.CalculateSalary();
		}
		
		
		return totalSalary;
	}
	/**
	public static void AddEmployeetoManager() {
		System.out.println("Enter the name or ID of employee: ");
		Scanner input= new Scanner (System.in);
		String emp= input.nextLine();
		System.out.println("Enter the name or ID of manager: ");
		
		String mgr= input.nextLine();
		
		if ( !IsEmployeeExist(emp) || !IsManagerExist(mgr) ) {
			System.out.println("There is no such employee or manager.Exiting");
			return;
		}
		
		
		boolean x= false;
		
		for (Staff staff:ls) {
			if (staff instanceof Manager) {
				if ( mgr.equalsIgnoreCase(staff.getName()) || mgr.equalsIgnoreCase(staff.getID()) ){
						Employee em= new Employee(ID,name,phoneNum, workDays, (Manager) staff);
						
						ls.add(em);
						x=true;
						System.out.println("Manager added");
						return;
				}
			}
		}
		
		
	}
	*/
}
