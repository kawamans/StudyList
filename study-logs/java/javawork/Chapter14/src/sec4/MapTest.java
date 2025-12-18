package sec4;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("apple", "りんご");
		dictionary.put("orange", "みかん");
		dictionary.put("apricot", "アンズ");
		dictionary.put("peach", "桃");
		dictionary.put("orange", "オレンジ");
		System.out.println(dictionary.get("apricot"));
		System.out.println(dictionary.get("orange"));
	}
}