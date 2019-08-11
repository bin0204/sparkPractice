import java.util.*;
import static java.lang.System.out;

public class TimeExample {

	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		TimeZone t = TimeZone.getTimeZone("US/Hawaii");
		c.setTimeZone(t);		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		int amPm = c.get(Calendar.AM_PM);
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);	
		String sAmPm = amPm == Calendar.AM ? "AM" : "PM";
		out.printf("Hawaii: %d년 %d월 %d일 %s %d시 %d분 %d초",
				year,month,date,sAmPm,hour,min,sec);
		
	}

}
