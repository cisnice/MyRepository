package ch09.exam13;

public class Button {	
	public static interface OnClickListener {
		void onClick();
	}
	
	private OnClickListener onClickListener;	
	public void setOnClickListener(OnClickListener onClickListener) {	//OnClickListener 를 구현한 객체가 들어온다.
		this.onClickListener = onClickListener;
	}

	public void click() {
		if(onClickListener != null) {
			onClickListener.onClick();	
		}
	}
}
