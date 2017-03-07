package wordCount.driver;

import java.util.Calendar;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;
import wordCount.visitors.grepVisitor;

/**
 * Driver Class
 * @author Rishi Sanas,Varun Kulkarni
 *
 */
public class Driver {

	public static void main(String[] args) throws Exception {
		try {
			if (args.length != 4) {
				System.err.println("Invalid Number of arguments");
				System.exit(1);
			}
			int NUM_ITERATIONS=0;
			
			try {
				NUM_ITERATIONS=Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				System.err.println(e.toString());
			}
			
			long millisStart = System.currentTimeMillis();
			int i=0;
			while(i!=NUM_ITERATIONS)
			{
				FileProcessor file_proc = new FileProcessor(args[0],false);
				BST bst=new BST();
				TreeProcessingVisitorI ptv = new PopulateTreeVisitor(file_proc);
				//String line = "";
				bst.accept(ptv);
				
				file_proc = new FileProcessor(args[1],true);
				TreeProcessingVisitorI gv = new grepVisitor(args[3],file_proc);
				bst.accept(gv);
				TreeProcessingVisitorI wcv = new WordCountVisitor(file_proc);
				bst.accept(wcv);
				
				i++;
				
				file_proc.closeFile();
			}
			long millisEnd = System.currentTimeMillis();
			System.out.println("Time taken "+ (millisEnd-millisStart)/NUM_ITERATIONS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			System.exit(1);
		}
		
	}

}
