package sample;

import genericUtility.JavaUtility;

public class JavaExecution {
	public static void main(String[] args) {
		JavaUtility jUtil = new JavaUtility();
		int value = jUtil.generateRandomNumber(200000);
		System.out.println(value);
		
		String datestamp=jUtil.getCalendarDetails("dd-MM-YYYY");
		System.out.println(datestamp);
		
		String dateTimeStamp=jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
		System.out.println(dateTimeStamp);
		
		String time=jUtil.getCalendarDetails("hh-mm-ss");
		System.out.println(time);
	}
	

}