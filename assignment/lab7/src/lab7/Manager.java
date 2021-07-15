package lab7;

public class Manager extends Employee{
	private int officeNum;
	private String team;
	
	Manager(String name, int employeeNum, int officeNum, String team){
		super(name, employeeNum, "Management");
		this.officeNum = officeNum;
		this.team = team;
	}
	public String toString() {
		return(super.toString() + "\nOffice# : " + this.officeNum + "\nTeam : " + this.team);
		
	}
	public boolean equals(Manager obj) {
		if(super.equals(obj) || this.officeNum != obj.officeNum || this.team != obj.team) {
			return false;
		}
		else {return true;}
	}

}
