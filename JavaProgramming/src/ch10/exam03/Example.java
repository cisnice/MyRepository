package ch10.exam03;

public class Example {

	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(100000);
		System.out.println(account.getBalance());
		
		try {
			account.withdraw(200000);
			System.out.println("출금이 되었습니다.");
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());					//e.getMessage()
			e.printStackTrace();
			System.out.println("출금이 되지 않았습니다.");
		}
	}

}
