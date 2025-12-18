package sec7ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex2 {

	public static void main(String[] args) {
		String strdate = "2023-04-16";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		String afterDate = sdf2.format(date);
		System.out.println("変換前：" + strdate);
		System.out.println("変換後：" + afterDate);
	}

}
