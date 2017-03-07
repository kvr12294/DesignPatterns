/*
 * WorkerThread has the method to run the threads created in CreateWorkers
 * 
 */
package primeThreads.threadMgmt;

import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class WorkerThread implements Runnable  {

	primeThreads.util.FileProcessor fp;
	 primeThreads.store.Results result;
	 primeThreads.util.IsPrime prime;
	public WorkerThread(primeThreads.util.FileProcessor fpIn,  primeThreads.store.Results resultIn, primeThreads.util.IsPrime primeIn)
	{
		 fp =  fpIn;
		 result = resultIn;
		 prime = primeIn;
		 Logger.writeMessage("In WorkerThread Constructor", DebugLevel.CONSTRUCTOR);
	}

    public void run() {
	// ...
		Logger.writeMessage("Run Method", DebugLevel.THREADSRUN);
    	String line = "";
    	try{
    		while((line = fp.readLineFromFile()) != null){
    			if(prime.isPrime(line)){
    				result.addPrime(Integer.parseInt(line));
    			}
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    

}