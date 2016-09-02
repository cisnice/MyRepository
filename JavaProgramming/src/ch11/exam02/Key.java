package ch11.exam02;

public class Key {
	
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Key ) {
			Key key = (Key)obj;
			if (number == key.number) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {		
		return number;			//number 만 같으면 hashCode가 같아진다.
	}
}
