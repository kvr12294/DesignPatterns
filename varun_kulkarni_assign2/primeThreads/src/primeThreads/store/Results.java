/*
 * Result class adds prime numbers obtained from input file
 * to ArrayList. It also prints the sum of all prime numbers using
 * WriteSumToScreen method
 */
package primeThreads.store;
import java.util.ArrayList;

import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;
public class Results implements StdoutDisplayInterface {
    // appropriate data structure as private data member
	ArrayList<Integer> L = new ArrayList<>(); //as we need dynamic storage
	
	public void addPrime(int num){
		L.add(num);
		Logger.writeMessage("Entry Added", DebugLevel.ENTRYINRESULTS);
	}
	
	public String printdatastructure(){
		String s1 = L.toString();
		return s1;
	}
	
    public void writeSumToScreen() {
    	int sum = 0;
    	for(int i: L){
    		sum += i;
    	}
    	System.out.println("The sum of all the prime numbers is: "+sum);
    }
    // appropriate method to save prime number to the data structure
} 


