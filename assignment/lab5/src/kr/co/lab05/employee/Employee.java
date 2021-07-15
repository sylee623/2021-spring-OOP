package kr.co.lab05.employee;

public class Employee {
	private	String name;
	private double yearlySalary;
	private double monthlySalary;
	private double balance;
	
	public Employee(String name, double yearlySalary) {
		this.name = name;
		this.yearlySalary = yearlySalary;
		this.monthlySalary = yearlySalary / 12;
		this.balance = 0;
	}
	public double getBalance(){
		return balance;
	}
	public void increaseYearlySalary(int byPercent ){
		this.yearlySalary = yearlySalary + byPercent/100. * yearlySalary; 
		this.monthlySalary = yearlySalary / 12;
	}
	public void receiveSalary(){
		this.balance = balance + monthlySalary;
	}
	public String toString() {
		return "이름:" + name + String.format(" 연봉 : %.2f", yearlySalary) + String.format(" 월급 : %.2f", monthlySalary)  + String.format(" 재산 : %.2f", balance);
	}
}
