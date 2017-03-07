package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	
	
	public MyAllTypesSecond(){
		myDoubleT = 0.0;
		myFloatT = 0;
		myShortT = 0;
		myCharT = '\0';
	}
	
	public MyAllTypesSecond(double myDoubleTIn, float myFloatTIn, short myShortTIn, char myCharTIn)
	{
		myDoubleT = myDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myCharT = myCharTIn;
	}

	public double getmyDoubleT() {
		return myDoubleT;
	}

	public void setmyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}

	public float getmyFloatT() {
		return myFloatT;
	}

	public void setmyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}

	public short getmyShortT() {
		return myShortT;
	}

	public void setmyShortT(short myShortT) {
		this.myShortT = myShortT;
	}

	public char getmyCharT() {
		return myCharT;
	}

	public void setmyCharT(char myCharT) {
		this.myCharT = myCharT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		result = prime * result + myShortT;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT)
			return false;
		if (Double.doubleToLongBits(myDoubleT) != Double.doubleToLongBits(other.myDoubleT))
			return false;
		if (Float.floatToIntBits(myFloatT) != Float.floatToIntBits(other.myFloatT))
			return false;
		if (myShortT != other.myShortT)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyAllTypesSecond [myDoubleT=" + myDoubleT + ", myFloatT=" + myFloatT + ", myShortT=" + myShortT
				+ ", myCharT=" + myCharT + "]";
	}
	
	
}
