/*
 * This class implements OddEvenFilterI interface
 * It returns true if UPDATE_VALUE provided in the arguments is EVEN
 */
package studentRecordsBackup.util;

public class EvenFilterImpl implements OddEvenFilterI {
	//Method that checks if the argument is Even
	//and returns true if it is even
	@Override
	public boolean checkOddEven(int UPDATE_VALUE) {
		if(UPDATE_VALUE % 2 != 0)
			return false;
		return true;
	}

}
