package ch11.exam10;

import java.util.Arrays;

public class ArraySortExample {

	public static void main(String[] args) {
		
		int[] scores = { 99, 97, 98 };
		
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
				
		
		Member2[] members = {
				new Member2("홍길동", 99),
				new Member2("박동수", 97),
				new Member2("김민수", 98)
		};
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
	}
}


class Member2 implements Comparable {
	String name;
	int score;
	
	Member2(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Object o) {				// sort 메소드가 호출한다. 음수값이 리턴되면 앞, 0이면 같다, 양수면 뒤로 간다. 
		System.out.println("CompareTo");
		Member2 target = (Member2) o;
//		return name.compareTo(target.name);		// 이름 올림차순
//		return target.name.compareTo(name);		// 이름 내림차순
		return score-target.score;						// 점수 올림차순
	}	
	
	@Override
	public String toString() {		
		return name;
	}
}












