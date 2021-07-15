package assignment2;

import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TravelScheduler {
	
	public static void main(String[] args) {
		Schedule[] scheduleList = new Schedule[5];
		
		Scanner keyboard = new Scanner(System.in);
		
		//activity list 만들기
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("./src/assignment2/ActivityList.txt"));
		}
		catch (FileNotFoundException e){
			System.out.println("ActivityList not found");
		}
		
		int n = input.nextInt();
		input.nextLine();
		Activity[] activityList = new Activity[n];
		for(int i = 0; i < n; i++) {
			String activity_info = input.nextLine();
			String[] activity_info_list = activity_info.split(",");
			for(int k = 2; k< activity_info_list.length; k++) {
				activity_info_list[k] = activity_info_list[k].replaceAll(" ", "");
			}
			if(activity_info_list[0].equals("Activity")) {
				activityList[i] = new Activity(activity_info_list[1],activity_info_list[2], Integer.parseInt(activity_info_list[3]));
				
			}
			else if(activity_info_list[0].equals("Show")) {
				activityList[i] = new ShowActivity(activity_info_list[1],activity_info_list[2], Integer.parseInt(activity_info_list[3]), Integer.parseInt(activity_info_list[4]));
			}
			else if(activity_info_list[0].equals("Extreme")) {
				activityList[i] = new ExtremeActivity(activity_info_list[1],activity_info_list[2], Integer.parseInt(activity_info_list[3]), Integer.parseInt(activity_info_list[4]), Integer.parseInt(activity_info_list[5]));
			}
		}
		
		try {
			input = new Scanner(new FileInputStream("./src/assignment2/MemberList.txt"));
		}
		catch (FileNotFoundException e){
			System.out.println("MemberList not found");
		}
		
		n = input.nextInt();
		Person[] personList = new Person[n];
		input.nextLine();
		for(int i=0; i < n; i++) {
			String person_info = input.nextLine();
			String[] person_info_list = person_info.split(",");
			for(int k = 1; k< person_info_list.length; k++) {
				person_info_list[k] = person_info_list[k].replaceAll(" ", "");
			}
			personList[i] = new Person(person_info_list[0],Integer.parseInt(person_info_list[1]),Integer.parseInt(person_info_list[2]),Integer.parseInt(person_info_list[3]));
		}
		/* ############################
		 * #	  프로그램 시작 지점		  #
		 * ############################
		 */
		
		while(true) {
			int s1 = 0;
			int s2 = 0;
			int s3 = 0;
			
			int tmp_num1, tmp_num2;
			System.out.println();
			System.out.println("1)Select schedule");
			System.out.println("2)Edit schedule");
			System.out.println("3)End schedule");
			System.out.print("Select menu : ");
			try {
				s1 = keyboard.nextInt();
				if(s1 < 1 || s1 > 3) {
					throw new InvalidAccessException(s1, 1, 3);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			
			System.out.println();
			
			if(s1 == 1) {
				showSchedule(scheduleList);
				System.out.print("Select a schedule : ");
				s2 = keyboard.nextInt();
				try {
					if(s2 > Schedule.scheduleNum) {
						throw new InvalidAccessException(s2 + " is EMPTY");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				if(s2 == 0) continue;
				else {
					System.out.println("1)Add Activity");
					System.out.println("2)Remove Activity");
					System.out.println("3)Print Schedule");
					System.out.print("Select menu : ");
					
					try {
						s3 = keyboard.nextInt();
						if(s3 < 1 || s3 > 3) {
							throw new InvalidAccessException(s3, 1, 3);
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
						continue;
					}
					
					System.out.println();
					
					if(s3 == 1) {
						Schedule tmp_schedule = addActivity(scheduleList[s2 -1], activityList, keyboard);
						if(tmp_schedule == null) {
							continue;
						}
						else {
							scheduleList[s2-1] = tmp_schedule;
						}
					}
					
					else if(s3 == 2) {
						scheduleList[s2 -1].printPlan();
						System.out.print("Select the day to remove activity : ");
						tmp_num1 = keyboard.nextInt();
						System.out.print("Enter the time to remove activity: ");
						tmp_num2 = keyboard.nextInt();
						try {
							if(!(scheduleList[s2 -1].checkPlan(tmp_num1, tmp_num2))) {
								throw new InvalidAccessException("There is no activity in day : " + tmp_num1 + " time : "+ tmp_num2);
							}
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
							continue;
						}
						scheduleList[s2 -1].delActivity(tmp_num1, tmp_num2);
						System.out.println("Removed Successfully!");
						System.out.println();
					}
					
					else if(s3 == 3) {
						scheduleList[s2 -1].printPlan();
						continue;
					}
				}
			}
			
			else if(s1 == 2) {
				System.out.println("1)Make a new schedule");
				System.out.println("2)Copy an existing schedule");
				System.out.print("Select menu : ");
				try {
					s2 = keyboard.nextInt();
					if(s2 < 1 || s2 > 3) {
						throw new InvalidAccessException(s2, 1, 3);
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
					continue;
				}
				if(s2 == 0) continue;
				else if(s2 == 1) {
					try {
						if(Schedule.scheduleNum >= 5) {
							throw new ArrayFullException("Schedule list is full");
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
					scheduleList = makeANewSchedule(scheduleList, personList, keyboard);
				}
				else if(s2 == 2) {
					try {
						if(Schedule.scheduleNum >= 5) {
							throw new ArrayFullException("Schedule list is full");
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
					scheduleList = copySchedule(scheduleList, keyboard);
				}
			}
			
			else if(s1 == 3) {
				System.out.println("Have a good travel !! Bye:)");
				System.exit(0);
			}
		}
		
	}
	
	
	//######## Limitation methods
	private static int limit(Scanner keyboard, int bound1, int bound2, String ask) {
		int input;
		System.out.print(ask);
		input = keyboard.nextInt();
		try {
			if(input < bound1 || input > bound2) {
				throw new InvalidAccessException(input, bound1, bound2);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			input = limit(keyboard, bound1, bound2, ask);
		}
		return input;
	}
	
	private static Person[] memberLimit(Scanner keyboard, Person[] personList) {
		String member_choice;
		String[] memberInfoList;
		Person[] memberList = null;
		
		try {
			int tmp = 0;
			System.out.print("Select members to choice : ");
			member_choice = keyboard.nextLine();
			
			memberInfoList = member_choice.split(",");
			memberList = new Person[memberInfoList.length];
			for(int k = 0; k< memberInfoList.length; k++) {
				memberInfoList[k] = memberInfoList[k].replaceAll(" ", "");
				tmp = Integer.parseInt(memberInfoList[k]);
				if(tmp < 1 || tmp > personList.length) {
					throw new InvalidAccessException(tmp, 1, personList.length);
				}
				memberList[k] = personList[tmp -1];
			}
			return memberList;
			
		}catch(InvalidAccessException e) {
			System.out.println(e.getMessage());
			memberLimit(keyboard, personList);
		}
		
		return memberList;
	}
	
	private static int insufficientLimit(Schedule schedule, Activity[] activityList, Scanner keyboard) {
		int activity_choice = 0;
		
		try {
			System.out.print("Select activity to do : ");
			activity_choice = keyboard.nextInt() -1;

			if(activity_choice < 0 || activity_choice > 9) {
				InvalidAccessException e = new InvalidAccessException(activity_choice, 1, 10);
				throw e;
			}
			Person[] tmp_member = schedule.getMember();
			if(activityList[activity_choice] instanceof ShowActivity) {
				for(int i=0; i < tmp_member.length; i++) {
					if(tmp_member[i].getAge() < ((ShowActivity) activityList[activity_choice]).getMinAge()) {
						InsufficientConditionException e = new InsufficientConditionException("min_age");
						throw e;
						
					}
				}
			}
			
			if(activityList[activity_choice] instanceof ExtremeActivity) {
				for(int i=0; i < tmp_member.length; i++) {
					if(tmp_member[i].getHeight() < ((ExtremeActivity) activityList[activity_choice]).getMinHeight() || tmp_member[i].getWeight() < ((ExtremeActivity) activityList[activity_choice]).getMinWeight()) {
						InsufficientConditionException e = new InsufficientConditionException("min_height or min_weihgt");
						throw e;
						
					}
				}
			}
			
			return activity_choice;
		}
		
		catch(Exception e){
			System.out.println(e);
			activity_choice = insufficientLimit(schedule, activityList, keyboard);
		}
		
		return activity_choice;
	}
	
	
	//function method
	
	private static void showSchedule(Schedule[] scheduleList) {
		for (int i =0; i < scheduleList.length ; i++ ) {
			if(i < Schedule.scheduleNum) System.out.println((i+1) + ")" + scheduleList[i].getName());
			else System.out.println((i+1) + ")" + "EMPTY SCHEDULE");
		}
	}
	
	private static Schedule addActivity(Schedule schedule, Activity[] activityList, Scanner keyboard) {
		int activity_choice, day, time;
		
		for (int k =0; k < activityList.length ; k++) {
			System.out.println((k+1) + ")" + activityList[k].toString());
		}
		
		activity_choice = insufficientLimit(schedule, activityList, keyboard);
		
		day = limit(keyboard, 1, schedule.getDays(), "Enter the day to do activity : ");
		time = limit(keyboard, 9, 20 ,"Enter the time to do activity : ");
		// 이미 activity가 존재하는 시간인지 확인
		try {
			if(!(schedule.checkPlan(day, time))) {
				throw new InvalidAccessException(day, time);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Fail to add activity");
			return null;
		}
		if(schedule.checkActivity(activityList[activity_choice ]) ){
			schedule.setActivity(day, time, activityList[activity_choice]);
			return schedule;
			}
		else {
			System.out.println("Fail to add activity");
			return null;
		}
	}
	
	
	private static Schedule[] makeANewSchedule(Schedule[] scheduleList, Person[] personList, Scanner keyboard){
//		String member_choice;
//		String[] memberInfoList;
		Person[] memberList;
		String tmp_name;
		int tmp_days;

		for (int i =0; i < personList.length ; i++ ) {
			System.out.println( (i+1) + ")" + personList[i].toString());
		}
		keyboard.nextLine();
		memberList = memberLimit(keyboard, personList);
		
		System.out.print("Enter a name for the schedule : ");
		tmp_name = keyboard.nextLine();
		
		tmp_days = limit(keyboard, 1, 5, "Enter travel days : ");
		
		scheduleList[Schedule.scheduleNum] = new Schedule(tmp_name, tmp_days, memberList);
		
		return scheduleList;
	}
	
	private static Schedule[] copySchedule(Schedule[] scheduleList, Scanner keyboard) {
		int copy_index;
		String schedule_name;
		showSchedule(scheduleList);
		copy_index = limit(keyboard, 0, Schedule.scheduleNum, "Select schedule to copy : ") -1 ;
		
		System.out.print("Enter a new schedule name : ");
		keyboard.nextLine();
		schedule_name = keyboard.nextLine();
		scheduleList[Schedule.scheduleNum] = new Schedule(schedule_name,scheduleList[copy_index]);
		System.out.println();
		
		return scheduleList;
	}
	
}