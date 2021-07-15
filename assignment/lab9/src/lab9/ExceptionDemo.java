package lab9;


import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Seoyeon");
		int hours;
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.print(emp1.getWorkDay() + "일차 근무 시간을 입력하세요 : ");
			hours = keyboard.nextInt();
			try {
				if(hours < 0) {
					throw new NegativeException();
				}
				else if (hours == 0) {
					throw new Exception("Program Exit");
				}
				else if(hours > 24) {
					throw new TooMuchStuffException(hours);
				}
				
				emp1.addWorkHours(hours);
				emp1.addWorkDay();
				System.out.println("이름 : " + emp1.getName());
				System.out.println("누적 근무시간 : " + emp1.getWorkHours());
				System.out.println("No Exception has been occurred");
				
			}
			catch(NegativeException e) {
				System.out.println(e.getMessage());
			}
			catch(TooMuchStuffException e) {
				System.out.println(e.getInputNum() +", "+ e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			finally {
				System.out.println("End of try-catch statement");
			}
			
		}
	}
}
