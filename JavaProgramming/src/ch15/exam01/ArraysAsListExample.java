package ch15.exam01;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Java", "Jdbc", "Database");		//List 안에 고정 길이 3짜리 내부 배열을 만듬. 추가, 삭제 안됨. ArrayList와는 다르다.
		System.out.println(list.size());
		
		for(String str : list) {
			System.out.println(str);
		}
		
		list.add("SQL");
		list.remove(1);
		
	}
}
