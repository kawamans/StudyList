package meetingroom.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Logger {
	
	private static final String LITERAL_START = "START";
	private static final String LITERAL_END = "END";
	private static final String DATE_FORMAT = "yyyy/MM/dd hh:mm:ss.SSS";
	
	public static void logStart(Throwable t) {
		log(t, LITERAL_START);
	}
	
	public static void logEnd(Throwable t) {
		log(t, LITERAL_END);
	}
	
	public static void log(Throwable t, Object obj) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		StackTraceElement element = t.getStackTrace()[0];
		System.out.println(
				"[MEMORY:" + String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + "]" +
				"[" + sdf.format(Calendar.getInstance().getTime()) + "]" +
				"[" + element.getClassName() + "]" +
				"[" + element.getMethodName() + "]" +
				"[" + element.getLineNumber() + obj + "]");
	}
	
	public static void log(final Exception e) {
		System.out.println("■ 例外:" +
				"[" + e.getStackTrace()[0].getClassName() + "]" +
				"[" + e.getStackTrace()[0].getMethodName() + "]" +
				"[" + e.getStackTrace()[0].getLineNumber() + "]");
	}
}
