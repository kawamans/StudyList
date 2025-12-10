package sec6;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("今年は" + c.get(Calendar.YEAR) + "年です。");
		c.add(Calendar.YEAR, 1);
		System.out.println("来年は" + c.get(Calendar.YEAR) + "年です。");
		System.out.println(c);
	}

}
