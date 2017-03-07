/*
* This is the main class where command lines arguments are validated.
* Also it instantiates Create worker class by passing the FileProcessor,
* Results and isprime as arguments.
*/
package primeThreads.driver;

import primeThreads.threadMgmt.CreateWorkers;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class Driver{
static int NUM_THREADS, DEBUG_VALUE;

	public static void main(String args[]) throws Exception {
		primeThreads.util.FileProcessor fp;
		primeThreads.store.Results result;
		primeThreads.util.IsPrime prime;
		
		
		
		if(args.length == 3)
		{
			NUM_THREADS = Integer.parseInt(args[1]);
				if(!(NUM_THREADS > 0 && NUM_THREADS <= 5))
				{ 
					System.err.println("Number of threads must be between 1 to 5");
					System.exit(1);		
				}
				DEBUG_VALUE = Integer.parseInt(args[2]);
				if(!(DEBUG_VALUE >= 0 && DEBUG_VALUE <= 4))
				{
					System.err.println("Debug value must be in the range of 0 to 4");
					System.exit(1);		
				}
		}
		else 
		{
			System.err.println("Too Few arguments");
			System.exit(1);			
		}
		
			//System.out.println("\n The args[0] is: " + args[0]);
			
			Logger.setDebugValue(DEBUG_VALUE);	
		 fp = new primeThreads.util.FileProcessor(args[0]);
		 result = new primeThreads.store.Results();
		 prime = new primeThreads.util.IsPrime(); 
		 
		 primeThreads.threadMgmt.CreateWorkers workers = new primeThreads.threadMgmt.CreateWorkers(fp, result, prime);
		 CreateWorkers cw=new CreateWorkers(fp, result, prime);
		 cw.startWorkers(NUM_THREADS);
		 result.writeSumToScreen();
		 Logger.writeMessage(result.printdatastructure(), DebugLevel.STOREDS);
		 //result.printdatastructure();
		//x Logger.writeMessage(result.printdatastructure(), DebugLevel.STOREDS);
	} // end main(...)

} // end public class Driver

