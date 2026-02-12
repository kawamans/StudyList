package sec2ex;

import java.util.ArrayList;
import java.util.List;

public class Group {
	List<Human> humans;
	
	public Group() {
		humans = new ArrayList<>();
	}
	
	public void add(Human human) {
		humans.add(human);
	}
	
	public Double average() {		
		double total = 0;
		for(Human human : humans) {
			total += human.getAge();
		}
		return humans.size() <= 0 ? null :total / humans.size();
	}
}
