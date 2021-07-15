package lab7;

public class Employee {
	private String name;
	private int employeeNum;
	private String department;
	
	public Employee(String name, int employeeNum, String department) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.department = department;
	}
	
	public String getName() {
		return this.name;
	}
	public int getEmployeeNum() {
		return this.employeeNum;
	}
	public String getDepartment() {
		return this.department;
	}
	
	public boolean equals(Employee obj) {
		if(this.name != obj.name || this.employeeNum != obj.employeeNum || this.department != obj.department ) {
			return false;
		}
		else {return true;}
	}
	public String toString() {
		return("Name : " + this.name + "\nEmp# : " + this.employeeNum + "\nDepartment : "+ this.department );
	}
}
