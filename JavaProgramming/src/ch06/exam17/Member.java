package ch06.exam17;

public class Member {
	private String mid;
	private String mname;
	private String mpassword;
	private int mage;
	private boolean madult;
	private double mheight;
	
	public Member(String mid) {
		this.mid = mid;
	}
	
	public String getMid(){			//getter 메소드. mid 값을 외부에 제공한다.
		return mid;
	}
	
	public void setMheight(double mheight) {		// setter 메소드. 항상 void로  
		if (mheight < 0 ){		// 데이터를 검증할 수 있는 코드 삽입가능.
			mheight = 0.0; 		// 올바른 값만 적용 될수 있게 할수 있다. (-)값이 들어왔을 경우
		}
		this.mheight = mheight;
		
	}

}
