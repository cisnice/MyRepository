package ch15.exam06;

public class Person implements Comparable<Person> {

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {		
		return name + "(" + age + ")";
	}

	@Override
	public int compareTo(Person target) {		// 주어진 객체와 같으면 0 리턴
		return (age-target.age); 						// 주어진 객체보다 적으면 음수 리턴
	}															// 주어진 객체보다 크면 양수 리턴	
	
	
}
