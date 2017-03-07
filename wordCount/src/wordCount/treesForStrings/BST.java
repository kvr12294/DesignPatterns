package wordCount.treesForStrings;

import wordCount.visitors.TreeProcessingVisitorI;
/**
 * Class to Create BST
 * @author Rishi Sanas,Varun Kulkarni
 *
 */

public class BST {
	private NODE root;
	public static NODE max;
//	private Result res;
	
	/**
	 * Constructor for Binary search tree
	 */
	public BST() {
		root = null;
		//res = new Result();
	}

	/**
	 * Insert Method used to insert Node in Binary search tree
	 * @param line
	 */
	public void insert(String line) {
		
		root = insert(root, line);
	}
/**
 * Recursive Method to insert node in tree
 * @param node
 * @param line
 * @return Node
 */
	public NODE insert(NODE node, String line) {
		//Method to Insert a Node into BST
		
		if (node == null)
		{
			NODE n1=new NODE(line);
			node = n1;
			node.setCount(1);
			node.setHash(line.hashCode());
		}
		else {
			if(line.hashCode()==node.getHash())
			{
				if(node.getdata().equals(line))
					node.setCount(node.getCount()+1);
			}
			else if (node.getdata().compareTo(line)>0)
				node.setleft(insert(node.getleft(), line));
			
			else if(node.getdata().compareTo(line)<0)
				node.setright(insert(node.getright(), line));
				
			}
		return node;
	}
	
	/**
	 * Accept Method to implement visitor pattern
	 * @param tpv (Visitor implementing Tree TreeProcessingVisitorI)
	 */
	public void accept(TreeProcessingVisitorI tpv){
		tpv.visit(this);
	}


	/**
	 * Method to check whether a given string is present, and if present return the count
	 * @param key
	 * @return count of the given string in the tree
	 */
	public int searchKey(String key)
	{
		NODE current=root;
		//int n=0;
		while(current!=null)
		{
			if(key.hashCode()==current.getHash())
			{
			if(current.getdata().equals(key))
				return current.getCount();
			}
			else if(current.getdata().compareTo(key)>0)
				current=current.getleft();
			else if(current.getdata().compareTo(key)<0)
				current=current.getright();
			//System.out.println(++n);
		}
		return 0;
}
	
	/**
	 * Calls recursive returnResult method to store result
	 * @param res
	 * @return Result computed
	 */
	
	public Result returnResult(Result res){
		returnResult(root,res);
		return res;
	}
	/**
	 * Method to store result(total words,total characters,Most frequently used word and its count)
	 * @param root
	 * @param res
	 */
	public void returnResult(NODE root,Result res){
		
		if(root != null){
			returnResult(root.getleft(),res);
			res.setwCount(res.getwCount()+root.getCount());
			res.setcCount(res.getcCount()+(root.getCharcount())*root.getCount());
			if(res.getFreqCount()==root.getCount())
			{
				res.setFreqWord(root.getdata());
			}
			if(res.getFreqCount()<root.getCount())
			{	
				res.clearFreqWordList();
				res.setFreqWord(root.getdata());
				res.setFreqCount(root.getCount());
			}
			returnResult(root.getright(),res);
		}
	}
}
