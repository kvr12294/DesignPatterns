/*
 * This class implements OddEvenFilterI interface
 * It returns false if UPDATE_VALUE provided in the arguments is ODD
 */
package studentRecordsBackup.util;

public class OddFilterImpl implements OddEvenFilterI {
	//Method that checks if the argument is odd
	//and returns false if it is odd
	@Override
	public boolean checkOddEven(int UPDATE_VALUE) {
		if(UPDATE_VALUE % 2 != 0)
			return true;
		return false;
	}	
}
