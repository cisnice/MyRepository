package ch15.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args) {
		
		Set<Member> set = new HashSet<>();
		
		Member m1 = new Member("홍길동", 25);
		Member m2 = new Member("홍길동", 25);
		
		System.out.println(m1 == m2);
		System.out.println(m1.hashCode() == m2.hashCode());		//true 가 되도록 Member 클래스에서 재정의
		System.out.println(m1.equals(m2));									//true 가 되도록 Member 클래스에서 재정의
																						//동등 객체가 되므로 중복 저장을 하지 않게 된다.
		
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
	}
}
