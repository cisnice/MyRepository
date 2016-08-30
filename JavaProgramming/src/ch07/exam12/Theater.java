package ch07.exam12;

public class Theater {
	public void check(Person person){
		if (person instanceof Adult) {			//person 이 Adult 이면 true
			Adult adult = (Adult) person;
			System.out.println("주민번호 : " + adult.ssn);
		}	
		
		if (person instanceof Student) {		//person 이 Student 이면 true
			Student student = (Student) person;
			System.out.println("학생번호 : " + student.sno);
		}
	}
}
