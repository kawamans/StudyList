package sec7ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex02a {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy月MM月dd");
		String str = sdf.format(date);
		System.out.println(str);
		
		String day = "2023-04-16";
		System.out.println(day);
		Date date2;
		try {
		date2 = sdf.parse(day);
		day = sdf.format(date2);
		System.out.println(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
