package lab10;

public class Animal {
	// -private instance variable로 String type의name을갖는다.
	// -name을 입력 받아서 초기화하는 생성자를 갖는다.
	// -name의 getter를 갖는다.
	
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
