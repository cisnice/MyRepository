package ch15.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		//List 계열의 컬렉션 생성
//		List<Object> list = new ArrayList<Object>();		// 타입 파리미터를 명시하지 않으면 기본적으로 Object형으로 만들어진다.
		List<String> list = new ArrayList<>();					// 앞에 명시되어있는 타입과 같다면 뒤에는 생략 가능
//		List<String> list = new Vector<>();
//		List<String> list = new LinkedList<>();
		
		//객체 저장
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");		
		list.add("iBatis");
		
		//저장된 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		//객체 찾기
		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();
		
		//전체 객체를 일괄 처리
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		System.out.println();
		
		for (String str : list) {						// 향상된 for Loop 를 이용하려면 Iterable 이 구현되어 있어야 한다.
			System.out.println(str);
		}
		System.out.println();
		
		// 삭제
		list.remove(2);	
		list.remove(2);				
		list.remove(new String("iBatis"));		// 내부적으로 equals로 비교해서 같으면 해당 객체가 지워진다.		
		System.out.println(list.size());
		
	}

}
