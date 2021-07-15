package lab10;

public class Program {
	public static void main(String[] args) {
		//Dog, Tiger, Turtle의 객체를 하나씩 만들어서, Animal array인 animals에 저장한다
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animals = new Animal[3];
		animals[0] = dog;
		animals[1] = tiger;
		animals[2] = turtle;
		
		//Person을 익명클래스를 이용해서 구현
		//속성으로 int 타입 private 변수 hp를갖고, hp는 100으로 초기화 한다
		Person person = new Person() {
			private int hp = 100;
			
			public void control(Animal animal) {
				if(animal.getName() == "Tiger") {
					this.hp -= 80;
				}
				else if (animal.getName() == "Dog") {
					this.hp -= 10;
				}
				else if(animal.getName() == "Trutle") {
					this.hp -= 0;
				}
				System.out.println("You have overpowered the " + animal.getName());
			}
			public void showInfo() {
				System.out.println("Person HP : " + this.hp);
			}
		};
		showResult(animals, person);
	}
	private static void showResult(Animal[] animals, Person p) {
		for(int i = 0 ; i < animals.length ; i++) {
			System.out.println(animals[i].getName());
			if(animals[i] instanceof Barkable) {
				System.out.println("Animal" + (i+1) + " barked " + ((Barkable) animals[i]).bark());
			}
			p.control(animals[i]);
			p.showInfo();
		}
	}
}
