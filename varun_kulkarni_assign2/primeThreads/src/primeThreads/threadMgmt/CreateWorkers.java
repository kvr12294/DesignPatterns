/*
 * CreateWorker instantiates multiple threads by using startWorkers
 * method which joins threads.
 */
package primeThreads.threadMgmt;

import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class CreateWorkers  {
	 primeThreads.util.FileProcessor fp;
	 primeThreads.store.Results result;
	 primeThreads.util.IsPrime prime;
	public CreateWorkers(primeThreads.util.FileProcessor fpIn,  primeThreads.store.Results resultIn, primeThreads.util.IsPrime primeIn)
	{
		 fp =  fpIn;
		 result = resultIn;
		 prime = primeIn;
		 Logger.writeMessage("In CreateWorkers Constructor", DebugLevel.CONSTRUCTOR);
	}

public void startWorkers(int NUM_THREADS )
{
	Thread[] w = new Thread[NUM_THREADS ];
	
		for(int i =0; i<NUM_THREADS ;i++)
		{
			w[i] = new Thread(new WorkerThread(fp,result,prime));
			w[i].start();
			try
			{
				w[i].join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
}
	// this class has the method startWokers(...)

}