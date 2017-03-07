/*
 * Interface hat has method to add observers and notify them
 */
package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenFilterI;

public interface SubjectI {
	public void addObserver(ObserverI observer, OddEvenFilterI oddeven);
	public void notifyObservers(int UPDATE_VALUE);
}
