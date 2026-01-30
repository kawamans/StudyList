package Animal;

public class AnimalMain {

	public static void main(String[] args) {
		
		Animal animal = new Animal("猫", "にゃあ");
		animal.sayName();
		animal.cry();
	
		animal = new Animal("ゴリラ", "ウホ", "バナナ");
		animal.sayName();
		animal.cry();
		animal.eat();
	
	}

}
