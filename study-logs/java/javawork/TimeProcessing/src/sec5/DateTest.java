package sec5;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		System.out.println("現在時刻：" + new Date());
		
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		System.out.println(month);
		
		c.add(Calendar.MONTH, 1);
		month = c.get(Calendar.MONTH);
		System.out.println(month);
	}

}
