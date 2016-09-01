package ch09.exam06;

public class A {
	int field = 10;
	
	public void method(){		
		final int local = 10;	    // final 로 선언해야 B클래스의 메소드에서 사용할 수 있다.			
		
		class B {						//로컬 클래스
			void method() {				
				field = 5;
//				local = 5;		
				int result = local + field;
			}
		}			
		B b = new B();
		
	}	
}
