package monster;

public class MonsterMain {

	public static void main(String[] args) {
		
		Monster monster = new Slime("スライム", "たいあたり");
		monster.sayName();
		monster.attack();
	
		monster = new Dragon("ドラゴン", "火の息");
		monster.sayName();
		monster.attack();
		
		BlueEyes be = new BlueEyes("ドラゴン", "火炎放射");
		be.evolution();
		be.skillUp();
		
	}

}
