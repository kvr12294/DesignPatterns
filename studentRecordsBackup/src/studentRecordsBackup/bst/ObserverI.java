/*
 * Observer interface which has update method 
 * which updates the observers on call to notify observers
 */
package studentRecordsBackup.bst;

public interface ObserverI {
	public void update(int updateVal);
}
