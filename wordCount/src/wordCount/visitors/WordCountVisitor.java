package wordCount.visitors;

import java.io.IOException;

import wordCount.treesForStrings.BST;
import wordCount.treesForStrings.NODE;
import wordCount.treesForStrings.Result;
import wordCount.util.FileProcessor;

/**
 * 
 * @author Rishi Sanas,Varun Kulkarni
 *
 */
public class WordCountVisitor implements TreeProcessingVisitorI
{
	FileProcessor fp;
	private NODE freq;
	private Result res;
	
	/**
	 * Constructor for WordCountVisitor
	 * @param fp
	 */
	public WordCountVisitor(FileProcessor fp) 
	{
		super();
		this.fp = fp;
		res = new Result();
	}


	/**
	 * Implementing visit method of TreeProcessingVisitorI interface,where we call returnResult of BST class 
	 * to get Result(total words,total characters,Most frequently used word and its count)
	 * @param BST
	 */
	@Override
	public void visit(BST bst) 
	{
		 bst.returnResult(res);
		try {
			fp.writeToFile(res.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	

}