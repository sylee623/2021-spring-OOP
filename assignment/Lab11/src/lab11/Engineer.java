package lab11;

public class Engineer extends Employee{
	public static int nextEngineerNumber = 2000;
	
	public Engineer(String name) {
		super.setName(name);
		super.setdepartment("Engineer");
		super.setSalary(3300);
		super.setEmployeeNum(nextEngineerNumber);
		nextEngineerNumber += 1;
	}
}
