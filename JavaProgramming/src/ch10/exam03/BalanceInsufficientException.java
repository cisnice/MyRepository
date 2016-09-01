package ch10.exam03;

public class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException(){}									// 무조건 생성자 두개 만들고 시작
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
