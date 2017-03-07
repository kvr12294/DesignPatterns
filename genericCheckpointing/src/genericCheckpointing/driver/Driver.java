package genericCheckpointing.driver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Vector;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {
    
    public static void main(String[] args) throws Exception 
    {
    	try
    	{
    		if(args.length != 3)
    		{
    			System.err.println("Invalid Number of arguments");
    			System.exit(1);
    		}
	// FIXME: read the value of checkpointFile from the command line
	String mode = args[0];
	int NUM_OF_OBJECTS = 0;
	try {
		NUM_OF_OBJECTS = Integer.parseInt(args[1]);
	} catch (NumberFormatException e) {
		System.err.println(e.toString());
	}
	ProxyCreator pc = new ProxyCreator();
	
	// create an instance of StoreRestoreHandler (which implements
	// the InvocationHandler
	StoreRestoreHandler handler = new StoreRestoreHandler();
	// create a proxy
	StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, handler);
		
	// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file

	MyAllTypesFirst myFirst;
	MyAllTypesSecond  mySecond;
	BufferedWriter bw = null;

	//FileProcessor fp = new FileProcessor("MyAllTypes2.txt");
	// Use an if/switch to proceed according to the command line argument
	// For deser, just deserliaze the input file into the data structure and then print the objects
	// The code below is for "serdeser" mode
	// For "serdeser" mode, both the serialize and deserialize functionality should be called.
	
	SerializableObject myRecordRet, myRecordRet1;

	// create a data structure to store the returned ojects
	//Vector<SerializableObject> vec =new Vector<>();
	//Vector<SerializableObject> vec1 =new Vector<>();
	ArrayList list = new ArrayList<SerializableObject>();
	ArrayList list1 = new ArrayList<SerializableObject>();
	// create a data structure to store the objects being serialized
        // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
    		if(mode.equals("serdeser"))
    		{
    			FileWriter fw = null ;
    			 try {
    				 //File file = new File(args[2]);
					fw = new FileWriter(new File(args[2]));
					 bw = new BufferedWriter(fw);
					// bw.write("DRIVER");
    			 	  } catch (Exception e) {
    			 		  e.printStackTrace();
    			 		  System.out.println(""+e.toString());
    			 		  System.exit(1);
    			 	  }
    			for (int i=0; i<NUM_OF_OBJECTS; i++) 
    			{
					// FIXME: create these object instances correctly using an explicit value constructor
					// use the index variable of this loop to change the values of the arguments to these constructors
					myFirst = new MyAllTypesFirst(i, i, mode, false);
					mySecond = new MyAllTypesSecond((double)3.14 * i, (float)31.4 + i, (short)12, 'c');
//					vec.addElement(myFirst);
//					vec.addElement(mySecond);
					System.out.println(myFirst.toString());
					System.out.println(mySecond.toString());
					list.add(myFirst);
					list.add(mySecond);
					// FIXME: store myFirst and mySecond in the data structure
					((StoreI) cpointRef).writeObj(myFirst, "XML", bw);
					((StoreI) cpointRef).writeObj(mySecond, "XML", bw);
    			}
    			bw.flush();
    			bw.close();
    			fw.close();
    			
    			FileProcessor fp = new FileProcessor(args[2]);
    			for(int j = 0; j < 2*NUM_OF_OBJECTS; j++)
				{
					myRecordRet1 = ((RestoreI) cpointRef).readObj("XML", fp);
					//vec1.addElement(myRecordRet1);
					System.out.println(myRecordRet1.toString());
					list1.add(myRecordRet1);
				}
    			fp.closeFile();
    			//bw.close();
    		}
    		else if(mode.equals("deser"))
    		{
    			//System.out.println("in read");
    			FileProcessor fp = new FileProcessor(args[2]);
    			for (int j=0; j<2*NUM_OF_OBJECTS; j++) 
    			{
    				//System.out.println("in read");
    				myRecordRet = ((RestoreI) cpointRef).readObj("XML", fp);
    				//((StoreI) cpointRef).readObj("XML");
    				//System.out.println("readobj called");
    				
    				//vec1.addElement(myRecordRet);
    				list1.add(myRecordRet);
    				// FIXME: store myRecordRet in the vector
    				
    			}
    			fp.closeFile();
    		}
    		else
    		{
    			System.out.println("Please provide mode to proceed!!!!");
    		}
    		
			// 	FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)
    		//bw.close();
			// FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
			// The comparison should use the equals and hashCode methods. Note that hashCode 
			// is used for key-value based data structures
    		int miss = 0, hit = 0;
//    		for(int i=0; i < NUM_OF_OBJECTS; i++)
//    		{
//    			System.out.println(vec.elementAt(i));
//    			System.out.println(vec1.elementAt(i));
//    			if(!(vec.get(i).equals(vec1.get(i))))
//    			{
//    				miss++;
//    			}
//    			else
//    			{
//    				hit++;
//    			}
//    		}
    		for(int i = 0; i < list.size() && i < list1.size(); i++)
    		{
    			//System.out.println(list.get(i));
    			//System.out.println(list1.get(i));
    			if(list.get(i).equals(list1.get(i)) && (list.get(i).hashCode() == list1.get(i).hashCode()))
    			{
    				hit++;
    			}
    			else
    			{
    				miss++;
    			}
    		}
    		System.out.println("Total Miss:-" + miss + "\n" + "Total hits:-" + hit);
    } 
    catch (Exception e) 
    {
		// TODO Auto-generated catch block
		System.out.println(e.toString());
		System.exit(1);
    }
}
}    
