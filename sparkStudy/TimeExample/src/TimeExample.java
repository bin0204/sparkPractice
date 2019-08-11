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
		out.printf("Hawaii: %d�� %d�� %d�� %s %d�� %d�� %d��",
				year,month,date,sAmPm,hour,min,sec);
		
	}

}
