package ch10.exam03;

public class Account {
	
	private long balance;

	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException {			//BalanceInsufficientException 클래스에서 RuntimeException을 상속하면 throws 를 빼도 된다.
//		balance -= money; 		// money 가 더 클수 도 있기때문에 안됨
		
		if (balance >= money) {
			balance -= money;
		} else {
			throw new BalanceInsufficientException("잔고 부족");		//예외 발생시키기. throw 로 예외를 발생시키면 직접 try catch 하지 않고 thows로 던져버린다.			
		}
	}
}
