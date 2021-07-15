package lab8;

public class Manager extends Employee{
	private double overtimeRate;
	private double rate;
	private int regularHrs;
	
	public Manager(String name, int employeeNum){
		super(name, employeeNum);
		super.setDepartment("Manager");
		this.rate = 4.0;
		this.overtimeRate = 8.0;
		this.regularHrs = 40;
		
	}
	
	public boolean equals(Manager obj) {
		if(super.equals(obj)) {
			return true;
		}
		else {return false;}
	}
	public String toString() { 
		return(super.toString() + ", " + super.getDepartment());
		
	}
	public double getPaid() {
		int overtimeHrs = super.getworkHrs() - this.regularHrs;
		if(super.getworkHrs()<40) return super.getworkHrs() * this.rate;
		else return (this.regularHrs * this.rate) + (overtimeHrs * this.overtimeRate);
	};
}
