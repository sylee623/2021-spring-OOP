package lab8;

public class Engineer extends Employee{
	private double rate;
	
	public Engineer(String name, int employeeNum){
		super(name, employeeNum);
		super.setDepartment("Engineering");
		this.rate = 4.0;
	}
	
	public boolean equals(Engineer obj) {
		if(super.equals(obj)) {
			return true;
		}
		else {return false;}
	}
	public String toString() { 
		return(super.toString() + ", " + super.getDepartment());
		
	}
	public double getPaid() {
		return super.getworkHrs() * this.rate;
	};
}
