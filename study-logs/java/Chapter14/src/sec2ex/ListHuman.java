package sec2ex;

import java.util.ArrayList;

public class ListHuman extends ArrayList<Human> {
	
	public double average() {		
		double total = 0;
		for(Human human : this) {
			total += human.getAge();
		}
		return this.size() <= 0 ? null :total / this.size();
	}
}
