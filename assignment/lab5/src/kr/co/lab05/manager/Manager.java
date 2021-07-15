package kr.co.lab05.manager;

import java.time.LocalDate;
import kr.co.lab05.employee.* ;

public class Manager {
	public static void main(String[] args) {
		Employee employee = new Employee("Lee", 4500);
		LocalDate currentDate = LocalDate.of(2021, 4, 1);
		
		System.out.println("계약일 : " + currentDate);
		System.out.println(employee.toString());
		
		int randomMonth = (int)(Math.random()*12)+1;
		int monthForWork = 0;
		int yearForWork = 1;
		while(employee.getBalance() < 20000) {
			employee.receiveSalary();
			if(currentDate.getMonthValue() == randomMonth) {
				employee.receiveSalary();
				System.out.println(yearForWork+ "년차 "+currentDate.getMonthValue()+"월에 인센티브를 받았습니다.");
			}
			if(monthForWork == 12) {
				int percent = (int)(Math.random()*10)+1;
				employee.increaseYearlySalary(percent);
				System.out.println(yearForWork + "년차 연봉이 " + percent+"% 만큼 증가했습니다.");
				yearForWork = yearForWork + 1 ;
				monthForWork = 0;
				randomMonth = (int)(Math.random()*12)+1;
			}
			if(employee.getBalance() >= 20000) {
				System.out.println("날짜 : " + currentDate.toString());
				System.out.println(employee.toString());
			}
			monthForWork = monthForWork + 1;
			currentDate = currentDate.plusMonths(1);
		}
	}
}
