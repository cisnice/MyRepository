package ch09.exam07;

public class A {
	int field;
	
	public void method(){				
		
		class B {				
			int field;
			B() {				
				field = 20;		
				this.field = 30;			// B 의 field
				A.this.field = 40;		// A 타입의 객체의 field
			}
		}			
		B b = new B();
		
		System.out.println("B 의 필드 : " + b.field);
		System.out.println("A 의 필드 : " + field);
		
	}	
}
