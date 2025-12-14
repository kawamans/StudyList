package sec7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParseTest {
	public static void main(String[] args) {
		//現在時刻をカレンダーで取得
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 10);
		//カレンダーをDate型に変換
		Date date = cal.getTime();
		//書式指定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");
		//Date→文字列変換
		String dateStr = sdf.format(date);
		
		System.out.println(dateStr);
		String str = "2000年1月20日 12時00分";
		//日付文字列→Date型
		Date date2;
		try {
			date2 = sdf.parse(dateStr);
			System.out.println(date2);
			date2 = sdf.parse(str);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}