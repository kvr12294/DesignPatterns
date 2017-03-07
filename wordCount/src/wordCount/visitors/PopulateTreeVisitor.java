package wordCount.visitors;

import java.io.IOException;
import java.util.StringTokenizer;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;

/**
 * Class to populate all words of the file in the Binary Search Tree
 * @author Rishi Sanas, Varun Kulkarni
 *
 */
public class PopulateTreeVisitor implements TreeProcessingVisitorI {
		FileProcessor fp;
		StringTokenizer st;
		
		/**
		 * Constructor of PopulateTreeVisitor Class
		 * @param fp
		 */
		public PopulateTreeVisitor(FileProcessor fp){
			this.fp = fp;
		}
	

		@Override
		
		/**
		 * Implementing visit method of TreeProcessingVisitorI interface,where we read line from file tokenize it 
		 * and insert it in the Binary Search Tree
		 */
		public void visit(BST b) 
		{
			String line;
			try 
			{
				while ((line = fp.readLineFromFile()) != null) 
				{
//					st = new StringTokenizer(line);
//				     while (st.hasMoreTokens()) 
//				     {
//				    	 String temp=st.nextToken().trim();
//				    	 if(temp.length()!=0)
//				    	 {
//				    		 b.insert(temp);
//				    	 }
//				     }
					
					String arr[]=line.split("\\W+");
					for (String string : arr) {
						if(string.trim().length()!=0)
						{
							b.insert(string);
							
						}	
						
						
					}
						
					
				}
			} 
			catch (IOException e) 
			{
				System.out.println(e.toString());
			}	
		}

}