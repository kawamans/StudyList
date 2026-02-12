package Animal;

public class Animal implements Actions {

	private String name;
	private String voice;
	private String food;
	
	public Animal(String name, String voice) {
		this.name = name;
		this.voice = voice;
	}
	
	public Animal(String name, String voice, String food) {
		this.name = name;
		this.voice = voice;
		this.food = food;
	}
	
	@Override
	public void sayName() {
		System.out.println(name + "です");
	}

	@Override
	public void cry() {
		System.out.println(voice);
	}
	
	@Override
	public void eat() {
		System.out.println(food + "が食べたい");
	}

}
