package ch11.ex13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePrintExample {

	public static void main(String[] args) {
		 Date now = new Date();
		 
		 Calendar we = Calendar.getInstance();
		 int week = we.get(Calendar.DAY_OF_WEEK);
		 String strWeek = null;
		 
//		 switch (week) {
//		 	case 1:
//		 		strWeek = "일요일";			
//		 		break;
//		 	case 2:
//		 		strWeek = "월요일";			
//		 		break;
//		 	case 3:
//		 		strWeek = "화요일";			
//		 		break;
//		 	case 4:
//		 		strWeek = "수요일";			
//		 		break;
//		 	case 5:
//		 		strWeek = "목요일";			
//		 		break;
//		 	case 6:
//		 		strWeek = "금요일";			
//		 		break;
//		 	case 7:
//		 		strWeek = "토요일";			
//		 		break;
//		 	default:
//		 		break;
//		}
		 
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 " + strWeek +" hh시 mm분");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		 String str = sdf.format(now);
		 System.out.println(str);
		
	}
}
