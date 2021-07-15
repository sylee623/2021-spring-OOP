package lab8;

public abstract class Employee {
	private String name;
	private int employeeNum;
	private String department;
	private int workHrs;
	private double salary;
	
	public Employee(String name,int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		workHrs = 0;
		salary = 0;
		department = "";
	}
	
	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getworkHrs() {
		return this.workHrs;
	}
	public double getSalary() {
		return this.salary;
	}
	
	public boolean equals(Employee obj) {
		if(this.employeeNum == obj.employeeNum  && this.name == obj.name) {
			return true;
		}
		else {return false;}
	}
	public String toString() {
		return( this.name + ", " + this.employeeNum );
	}
	
	public void doWork(int hrs) {
		this.workHrs += hrs;
		this.salary = getPaid();
	}
	
	public abstract double getPaid();
}
