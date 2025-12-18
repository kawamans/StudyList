package sec3;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> codes = new HashSet<String>();
		codes.add("Alpha");
		codes.add("Bravo");
		codes.add("Charlie");
		for (String code : codes) {
			System.out.println(code);
		}
		System.out.println("---------------------------");
		codes.remove("Alpha");
		codes.remove("Charlie");
		for (String code : codes) {
			System.out.println(code);
		}
	}
}