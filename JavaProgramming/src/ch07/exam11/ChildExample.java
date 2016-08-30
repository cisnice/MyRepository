package ch07.exam11;

public class ChildExample {

	public static void main(String[] args) {
//		Parent parent = new Child();
//		parent.field1 = "data";
//		parent.method1();
//		parent.method2();
//		
////		parent.field2 = "data2";		
////		parent.method3();			
//		
//		Child child = (Child) parent;
//		child.field2 = "yyy";
//		child.method3();
		
		Parent parent = new Parent();
		
		Child child = (Child) parent;		//타입변환 안됨. CastException
		
		
		
	}

}
