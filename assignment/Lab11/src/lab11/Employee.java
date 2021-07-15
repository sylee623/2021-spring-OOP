package lab11;

public class Employee {
	String name;
	int employeeNum;
	String department;
	double salary;
	
	public String getName() {
		return this.name;
	}
	public int getEmployeeNum() {
		return this.employeeNum;
	}
	public String getdepartment() {
		return this.department;
	}
	public double getSalary() {
		return this.salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	public void setdepartment(String department) {
		this.department = department;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return ("\nName : " + this.name + "\nEmployee Number : " + this.employeeNum + "\nDepartment : " + this.department + "\nSalary : " + this.salary );
	}
}
