package ch12.exam07;

import java.util.Calendar;

public class EnumExample {

	public static void main(String[] args) {

		Week week;		//enum 에서 열거된 상수만 사용가능				
//		int week;
		
		Calendar now = Calendar.getInstance();		
		switch (now.get(Calendar.DAY_OF_WEEK)) {
		case 1:
//			week = 1;
			week = Week.SUNDAY;
			break;
		case 2:
//			week = 2;
			week = Week.MONDAY;
			break;
		case 3:
//			week = 3;
			week = Week.TUESDAY;
			break;
		case 4:
//			week = 4;
			week = Week.WEDNESDAY;
			break;
		case 5:
//			week = 5;
			week = Week.THURSDAY;
			break;
		case 6:
//			week = 6;
			week = Week.FRIDAY;
			break;		
		default :
//			week = 7;
			week = Week.SATURDAY	;			
		}
		System.out.println(week);
		
//		if (week == 6) {
//		if (week == Week.FRIDAY) {
//			
//		}
	}
}
