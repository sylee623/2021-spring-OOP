package lab7;

public class Engineer extends Employee{
	 private String workZone;
	 private String project;
	 
	 Engineer(String name, int employeeNum, String workZone, String project){
			super(name, employeeNum, "Engineering");
			this.workZone = workZone;
			this.project = project;
		}
	 public boolean equals(Engineer obj) {
			if(super.equals(obj) || this.workZone != obj.workZone || this.project != obj.project) {
				return false;
			}
			else {return true;}
		}
	 public String toString() {
			return(super.toString() + "\nZone : " + this.workZone);
			
		}
}
