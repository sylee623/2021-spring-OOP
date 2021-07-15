package lab11;

import java.util.ArrayList;

public class Management {
	public static <T extends Employee>void moveDepartment(T t, String department){
		t.setdepartment(department);
	}
	
	public static <T extends Employee>void raiseSalary(T t, double rate){
		t.setSalary(t.getSalary()*rate);
	}
	
	public static <T extends Employee>int findIndexByEmpNum(ArrayList<T> tList, int employeeNum){
		int idx = -1;
		for (T emp:tList) {
			if(emp.getEmployeeNum() == employeeNum) {
				idx = tList.indexOf(emp);
				break;
			}
		}
		return idx;
	}
	
	public static <T extends Employee>void raiseAllSalary(ArrayList<T> tList, double rate){
		for (T emp:tList) {
			emp.setSalary(emp.getSalary() * rate);
		}
	}
}
