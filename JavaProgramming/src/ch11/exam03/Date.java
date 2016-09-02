package ch11.exam03;

import java.util.Calendar;

public class Date {

	@Override
	public String toString() {
		Calendar now = Calendar.getInstance();			//Calendar 에 있는 static 메소드 호출
		int year = now.get(Calendar.YEAR);				// Calendar 에 있는 상수 호출	
		int month = now.get(Calendar.MONTH) + 1;   //Month가 0~11 까지라서 (+1)
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		return year + "-" + month + "-" + day;
	}
	
}
