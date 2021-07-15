package assignment2;

public class Person {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Person(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public int getAge() {
		return this.age;
	}
	public int getHeight() {
		return this.height;
	}
	public int getWeight() {
		return this.weight;
	}
	public String toString() {
		return "Name : " + this.name + ", Age : " + this.age + ", Height : " + this.height + ", Weight : " + this.weight;
	}
}
