package sec2ex;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		List<Human> humans = new ArrayList<>();
		
		humans.add(new Human("手塚雄彦", 48));
		humans.add(new Human("井ノ上たかを", 27));
		humans.add(new Human("さいとう理", 35));
		
		for(Human human : humans) {
			System.out.println(human);
		}
	}	

}





