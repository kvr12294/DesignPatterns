package wordCount.treesForStrings;

import java.util.HashMap;
/**
 * Class to create Node of the Binary Search tree
 * @author Rishi Sanas,Varun Kulkarni
 *
 */
public class NODE {
	private NODE left, right;
	private String data;
	private int count;
	private int charcount;
	private int hash;
	
	/**
	 * Constructor of the Node Class
	 * @param word
	 */
	public NODE(String word) {		
		left = null;
		right = null;
		data = word;
		charcount=word.length();
		count=0;
		
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public int getCharcount() {
		return charcount;
	}

	public void setCharcount(int charcount) {
		this.charcount = charcount;
	}


	public void setleft(NODE n) {
		left = n;
	}

	public void setright(NODE n) {
		right = n;
	}

	public NODE getleft() {
		return left;
	}

	public NODE getright() {
		return right;
	}

	public void setdata(String n) {
		data = n;
	}

	public String getdata() {
		return data;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
