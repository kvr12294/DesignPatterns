package wordCount.visitors;

import wordCount.treesForStrings.BST;
import wordCount.util.FileProcessor;
/**
 * 
 * @author Rishi Sanas, Varun Kulkarni
 *
 */
public class grepVisitor implements TreeProcessingVisitorI{

		String key;
		FileProcessor fp;
	
	/**
	 * Constructor for grepVisitor Visitor class
	 * @param key
	 * @param fp
	 */
	public grepVisitor(String key,FileProcessor fp) 
	{
			super();
			this.key = key;
			this.fp = fp;
		}



	@Override
	/**
	 * Implementing visit method of TreeProcessingVisitorI interface,where we print count of search string mentioned in 
	 * command prompt.
	 */
	public void visit(BST bst) {
		try {
			
				int count=bst.searchKey(key);
				fp.writeToFile("\nThe word \""+key+"\" occurs the following times: "+count+"\n");
			} 
			catch (Exception e) 
			{
				System.out.println(e.toString());
			}
	}
	
}
