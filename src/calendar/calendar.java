package calendar;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class calendar {

	private final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap <Date, PlanItem> planMap;
	
	public calendar(){
		planMap = new HashMap<Date, PlanItem>();
	}
	
	/**
	 * 
	 * @param date ex: "2017-06-20"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan){
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(),  p);
}
	
	public PlanItem searchPlan(String strDate){
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
		
	}
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}
		return MAX_DAYS[month];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d%3d>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		// get weekday automatically
		int weekday = getweekday(year, month, 1);
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		count++;
		// print from second line to last
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim)
				System.out.println();
		}
		System.out.println();
		System.out.println();

	}

	private int getweekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970/Jan/1st = Thursday

		int count = 0;
		for(int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366: 365;
			count += delta;
		}
		
		for(int i =1; i < month; i++){
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	public static void main(String[] args) throws ParseException{
		calendar cal = new calendar();
		System.out.println(cal.getweekday(1970, 1, 1)==4);
		System.out.println(cal.getweekday(1971, 1, 1)==5);
		System.out.println(cal.getweekday(1972, 1, 1)==6);
		System.out.println(cal.getweekday(1973, 1, 1)==1);
		System.out.println(cal.getweekday(1974, 1, 1)==2);
		
		cal.registerPlan("2017-06-23", "Let's eat beaf");
		System.out.println(cal.searchPlan("2017-06-23").equals("Let's eat beaf"));
	}
}