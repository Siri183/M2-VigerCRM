package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This is generic class which deals with java related activities
 * @author SiriG
 *
 */
public class JavaUtility {
	/**
	 * This method is used to generate a random number within the given range as argument
	 * @param bound
	 * @return
	 */
	public int generateRandomNumber(int bound){
		Random r=new Random();
		int value = r.nextInt(bound);
		return value;
		
	}
	/**
	 * This method is used to get Calendar Details for the given pattern as argument
	 * @param pattern
	 * @return
	 */
	public String getCalendarDetails(String pattern) {
		Calendar cal=Calendar.getInstance();
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String value=sdf.format(d);
		return value;
		
	}

}