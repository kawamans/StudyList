package sec2ex;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("手塚雄彦");
		names.add("井ノ上たかを");
		names.add("さいとう理");
		names.remove(0);
		names.remove(1);
		for (String name : names) {
			System.out.println(name);
		}
	}
}
