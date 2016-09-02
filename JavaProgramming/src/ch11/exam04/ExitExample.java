package ch11.exam04;

public class ExitExample {

	public static void main(String[] args) {
		
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {				//exit 가 실행되면  checkExit 실행되고 프로그램 종료.
				if ( status != 5) {									// status 가 5가 되면 종료
					throw new SecurityException();			// runtime exception. catch 에서 예외처리
				}
				System.out.println("나 죽네");
			}			
		} );
		
		for ( int i = 0; i<10; i++ ) {
			System.out.println(i);
			
			try {
				System.exit(i);		// 프로그램 종료. exit 뒤에오는 숫자로 종료가 될지 안될지 결정한다. 
//				break;				// for 문 종료
//				return;				// 메소드 실행 종료
			} catch(SecurityException e) {
				
			}

		}
		System.out.println("내가 출력될까요?");
	}
	
//	public static void method(int x) {
//		if ( x ==5 ) {
//			return;
//		}
//		System.out.println(x);
//	}

}
