package sec2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		// ArrayListをインスタンス化
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println("---ArrayListの要素");
		for (Integer num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
		//ArrayListからLinkedListをインスタンス化
		List<Integer> list2 = new LinkedList<Integer>(list);
		list2.remove(1);
		list2.remove(2);
		System.out.println("---LinkedListの要素");
		for (Integer num : list2) {
			System.out.print(num + " ");
		}
	}
}