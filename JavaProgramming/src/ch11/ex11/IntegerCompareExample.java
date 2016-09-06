package ch11.ex11;

public class IntegerCompareExample {

	public static void main(String[] args) {

		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 400;
		
		System.out.println( obj1 == obj2);	//true
		System.out.println( obj3 == obj4);	//false
		
		//byte, short, int 는 -128~127 까지만 (==) 와 (!=) 로 비교할 수 있다. 그 이외의 경우에는 equals로 비교 해야한다.
	}

}
