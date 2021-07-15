package lab11;

public class Manager extends Employee{
	public static int nextManagerNumber = 1000;
	
	public Manager(String name) {
		super.setName(name);
		super.setdepartment("Manager");
		super.setSalary(3000);
		super.setEmployeeNum(nextManagerNumber);
		nextManagerNumber += 1;
	}
}
