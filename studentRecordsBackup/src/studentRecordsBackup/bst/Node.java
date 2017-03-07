/*
 * Node class creates the Node of BST 
 * It has getters and setters method for its nodes.
 * It also implements Subject and Observer Interface
 * 
 */
package studentRecordsBackup.bst;
import java.util.HashMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import studentRecordsBackup.util.OddEvenFilterI;
/**
 * @author Varun Kulkarni
 *
 */
public class Node implements SubjectI, ObserverI{
	/**
	 * Creates a node and return It.
	 */	
	private HashMap<ObserverI, OddEvenFilterI> observerhm= new HashMap<ObserverI, OddEvenFilterI>(); // Data Structure To store Observers
	Node left, right;
	int data;

	public Node(int Bnumber) {
//		observerhm 		
		left = null;
		right = null;
		data = Bnumber;
	}
	
	/*public Node(int n) {
		left = null;
		right = null;
		data = n;
	}*/

	public void setleft(Node n) {
		left = n;
	}

	public void setright(Node n) {
		right = n;
	}

	public Node getleft() {
		return left;
	}

	public Node getright() {
		return right;
	}

	public void setdata(int n) {
		data = n;
	}

	public int getdata() {
		return data;
	}

	@Override
	public void update(int updateValue) {
		data+=updateValue;
	}

	//Method to add observers into the data structure
	@Override
	public void addObserver(ObserverI observer, OddEvenFilterI oddeven) {
		observerhm.put(observer, oddeven);
	}

	//Method to notify all observers Backup1 and Backup2 Based on 
	//Odd Even Filter and accordingly update Backup1 or Backup2
	@Override
	public void notifyObservers(int updateValue) {
		 for(HashMap.Entry<ObserverI, OddEvenFilterI> entry : observerhm.entrySet()){
			 ObserverI observers = (ObserverI) entry.getKey();
			 if(observerhm.get(observers).checkOddEven(updateValue))
			observers.update(updateValue);
		 }
	}
}
