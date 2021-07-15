package assignment2;

public class Schedule {

	private String name;// Schedule 이름
	private int days;// Schedule 전체일수
	private Activity[][] plan;// Schedule 일정
	private int expense;// Schedule 전체비용
	
	private Person[] member;
	
	public static int scheduleNum = 0;// 생성된Schedule 객체의수
	
	public Schedule(String name, Schedule obj) {
		this.name = name;
		this.days = obj.getDays();
		this.expense = obj.getExpense();
		this.plan = new Activity[5][12];
		for(int d = 0; d < days; d++) {
			for(int t=0; t<12; t ++) {
				if(!(obj.checkPlan(d+1, t+9))){
					plan[d][t] = obj.getActivity(d+1, t+9);
				}
			}
		}
		this.member = obj.member; //수정필
		
		scheduleNum += 1;
	}
	
	public Schedule(String name, int days , Person[] member){
		this.name = name;
		this.days = days;
		this.expense = 0;
		this.plan = new Activity[5][12];
		scheduleNum += 1;
		this.member = new Person[member.length];
		for(int i=0; i<member.length; i++) {
			this.member[i] = member[i];
		}
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getDays() {
		return this.days;
	}
	
	public int getExpense() {
		return this.expense;
	}
	
	public Person[] getMember() {
		Person[] tmp_member = new Person[this.member.length];
		for(int i=0; i<member.length; i++) {
			tmp_member[i] = this.member[i];
		}
		return tmp_member;
	}
	
	public boolean checkPlan(int day, int time) {
		day = day-1;
		time = time-9;
		if(plan[day][time] == null) return true;
		else return false;
	}
	
	public Activity getActivity(int day, int time) {
		day = day-1;
		time = time -9;
		if(this.plan[day][time] instanceof ShowActivity) {
			return new ShowActivity((ShowActivity) this.plan[day][time]);
		}
		else if (this.plan[day][time] instanceof ExtremeActivity) {
			return new ExtremeActivity((ExtremeActivity) this.plan[day][time]);
		}
		else {
			return new Activity(this.plan[day][time]);
		}
	}
	
	
	public void setActivity(int day, int time, Activity obj) {
		day = day-1;
		time = time-9;
		if(obj instanceof ShowActivity) {
			this.plan[day][time] = new ShowActivity((ShowActivity) obj);
		}
		else if(obj instanceof ExtremeActivity) {
			this.plan[day][time] = new ExtremeActivity((ExtremeActivity) obj);
		}
		else {
			this.plan[day][time] = new Activity(obj);
		}
		for(int i=0; i<member.length; i++) {	
			this.expense += obj.getActualPrice(this.member[i]);
		}
	}
	
	public boolean checkActivity(Activity obj) {
		for(int d = 0; d < days; d++) {
			for(int t=0; t<12; t ++) {
				if(!(checkPlan(d+1,t+9))) {
					if(plan[d][t].equals(obj)) return false;
				}
			}
		}
		return true;
	}
	
	public void printPlan() {
		System.out.println("-".repeat(16*6));
		for(int t=0; t<=12; t++) {
			if(t == 0) {
				System.out.printf("%-16s","");
				for( int d = 1; d <= 5; d++) {
					System.out.printf("%-16s","Day " + d);
				}
				System.out.println();
			}
			else {
				System.out.printf("%-16s",(t+8) + ":00" );
				for( int d = 1; d <= 5; d++) {
					if(checkPlan(d,t+8)) System.out.printf("----" + "\t".repeat(2));
					else System.out.printf("%-16s",getActivity(d,t+8).getName());
				}
				System.out.println();
			}
		}
		System.out.println("-".repeat(16*6));
		System.out.printf("Total expenses: %d won\n", expense);
		System.out.println("-".repeat(16*6));
		
	}
	
	public void delActivity(int day, int time) {
		day = day-1;
		time = time-9;
		for(int i=0; i<member.length; i++) {	
			this.expense -= plan[day][time].getActualPrice(this.member[i]);
		}
		plan[day][time] = null;
	}
}
