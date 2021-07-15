package assignment1;

import java.util.Scanner;

public class TravelScheduler {
	public static void main(String[] args) {
		Schedule[] scheduleList = new Schedule[5];
		Activity[] activityList = new Activity[8];
		//activity list 선언(8)
		
		Scanner keyboard = new Scanner(System.in);
		
		
		activityList[0] = new Activity("Hiking", "Mountain", 0);
		activityList[1] = new Activity("Horse Riding", "Hill", 3000);
		activityList[2] = new Activity("Visiting Museum", "Museum", 8000);
		activityList[3] = new Activity("Watching movie", "Theater", 11000);
		activityList[4] = new Activity("Fishing", "Sea", 15000);
		activityList[5] = new Activity("Surffing", "Beach", 20000);
		activityList[6] = new Activity("Camping", "Field", 30000);
		activityList[7] = new Activity("Paragliding", "Mountain", 50000);
		
		/* ############################
		 * #	  프로그램 시작 지점		  #
		 * ############################
		 */
		while(true) {
			int s1 = 0;
			int s2 = 0;
			int s3 = 0;
			int end_program = 0;
			
			int tmp_days;
			int tmp_num1, tmp_num2, tmp_num3;
			int is_ok = 0;
			String tmp_name;
			System.out.println();
			System.out.println("1)Select schedule");
			System.out.println("2)Edit schedule");
			System.out.println("3)End schedule");
			System.out.print("Select menu : ");
			
			s1 = keyboard.nextInt();
			
			System.out.println();
			
			//1)Select schedule
			if(s1 == 1) {
				for (int i =0; i < scheduleList.length ; i++ ) {
					if(i < Schedule.scheduleNum) System.out.println((i+1) + ")" + scheduleList[i].getName());
					else System.out.println((i+1) + ")" + "EMPTY SCHEDULE");
				}
				System.out.print("Select a schedule : ");
				s2 = keyboard.nextInt();
				if(s2 == 0) continue;
				else if(s2 > Schedule.scheduleNum) continue;
				else {
					System.out.println("1)Add Activity");
					System.out.println("2)Remove Activity");
					System.out.println("3)Print Schedule");
					System.out.print("Select menu : ");
					s3 = keyboard.nextInt();
					System.out.println();
					if(s3 == 0) continue;
					
					//1) Add Activity
					else if(s3 == 1) {
						for (int k =0; k< activityList.length ; k++) {
							System.out.println((k+1) + ")" + activityList[k].toString());
						}
						System.out.print("Select activity to do : ");
						tmp_num1 = keyboard.nextInt();
						System.out.print("Enter the day to do activity : ");
						tmp_num2 = keyboard.nextInt();
						if(tmp_num2 > scheduleList[s2 -1].getDays()) {
							System.out.println("Limit of day is "+ scheduleList[s2 -1].getDays() +", Fail to add Activity");
							continue;
							}
						System.out.print("Enter the time to do activity : ");
						tmp_num3 = keyboard.nextInt();
						if(tmp_num3 > 20 || tmp_num3 < 9) {
							System.out.println("You have to select time between 9 to 20. Fail to add Activity");
							continue;
							}
						
						if(scheduleList[s2 -1].checkPlan(tmp_num2, tmp_num3) && scheduleList[s2 -1].checkActivity(activityList[tmp_num1 -1]) ){
							scheduleList[s2 -1].setActivity(tmp_num2, tmp_num3, activityList[tmp_num1 -1]);
							continue;
						}
						else {
							System.out.println("Fail to add activity");
							continue;
						}
					}
//							
					else if(s3 ==2) {
						scheduleList[s2 -1].printPlan();
						System.out.print("Select the day to remove activity : ");
						tmp_num1 = keyboard.nextInt();
						System.out.print("Enter the time to remove activity: ");
						tmp_num2 = keyboard.nextInt();
						scheduleList[s2 -1].delActivity(tmp_num1, tmp_num2);
						System.out.println("Removed Successfully!");
						System.out.println();
					}
						
						
					//3) Print schedule
					else if(s3 == 3) {
						scheduleList[s2 -1].printPlan();
						continue;
					}
				}
				// else : 이 부분은 s3
			}	
		//2)Edit schedule
			else if(s1 == 2){
				System.out.println("1)Make a new schedule");
				System.out.println("2)Copy an existing schedule");
				System.out.print("Select menu : ");
				s2 = keyboard.nextInt();
				if(s2 == 0) continue;
				else if(s2 ==1){
					System.out.print("Enter a name for the schedule : ");
					keyboard.nextLine();
					tmp_name = keyboard.nextLine();
					System.out.print("Enter travel days : ");
					tmp_days = keyboard.nextInt();
					if(tmp_days > 5 || tmp_days <= 0) {
						System.out.println("You have to choose days between 1 to 5. Fail to create schedule");
						continue;
					}
					
					scheduleList[Schedule.scheduleNum] = new Schedule(tmp_name, tmp_days);
					System.out.println();
				}
				else if (s2 == 2){
					for (int i =0; i < scheduleList.length ; i++ ) {
						if(i < Schedule.scheduleNum) System.out.println((i+1) + ")" + scheduleList[i].getName());
						else System.out.println((i+1) + ")" + "EMPTY SCHEDULE");
					}
					System.out.print("Select a schedule to copy : ");
					s2 = keyboard.nextInt();
					
					System.out.print("Enter a new schedule name : ");
					keyboard.nextLine();
					tmp_name = keyboard.nextLine();
					scheduleList[Schedule.scheduleNum] = new Schedule(tmp_name,scheduleList[s2-1]);
					System.out.println();
					
				}
			}
		//3)End schedule
			else if(s1==3) {
				System.out.println("Have a good travel !! Bye:)");
				System.exit(0);
			}

		}
		
	}
}
