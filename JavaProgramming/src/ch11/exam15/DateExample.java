package ch11.exam15;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {

		Date now = new Date();
		System.out.println(now.toString());

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = sdf.format(now);
		System.out.println(strDate);
		
		Calendar cal = Calendar.getInstance();	//new 를 쓸 수 없다. calendar는 protected 라 외부에서 접근할 수 없음. calendar 객체의 static 필드, 메소드를 사용한다.
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;			// 0~11. +1 해줘야한다.
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int ampm = cal.get(Calendar.AM_PM);
		int week = cal.get(Calendar.DAY_OF_WEEK);		// 일요일 1 ~ 토요일 7
		
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		System.out.println("hour : " + hour);
		System.out.println("minute : " + minute);
		System.out.println("second : " + second);
		System.out.println("ampm : " + ampm);
		System.out.println("week : " + week);
		
		
	}

}
