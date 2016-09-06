package ch11.exam11;

import java.util.Arrays;

public class ArraySortExample {

	public static void main(String[] args) {

		Board[] boardArr = {
				new Board(3, "오늘은 화요일"),
				new Board(1, "다음주는 추석"),
				new Board(5, "과제가 있을까"),
		};
		
		Arrays.sort(boardArr);										//java.lang.ClassCastException: ch11.exam11.Board cannot be cast to java.lang.Comparable
		System.out.println(Arrays.toString(boardArr));		//sort 안에서 자동 형변환이 일어난다. 그때 캐스트 에러 발생. Board 클래스에서 Comparable 구현해주고 compareTo 메소드 정의
	}

}
