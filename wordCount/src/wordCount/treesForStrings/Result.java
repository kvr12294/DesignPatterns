package wordCount.treesForStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create Instance of Result(total words,total characters,Most frequently used words and its count)
 * @author Rishi Sanas, Varun Kulkarni
 *
 */
public class Result {
	private long wCount; //total words
	private long cCount; // total characters
	private List<String> freqWord; //most frequently used words
	private long freqCount; // count of most frequently used word
	
	/**
	 * Constructor of Result Class
	 */
	public Result() {
		super();
		wCount = 0;
		cCount = 0;
		freqWord = new ArrayList<String>();;
		freqCount = 0;
	}
	
	/**
	 * Getter method for total words count
	 * @return wCount
	 */
	public long getwCount() {
		return wCount;
	}
	
	/**
	 * Setter method for total wordCount
	 * @param wCount
	 */
	public void setwCount(long wCount) {
		this.wCount = wCount;
	}
	
	/**
	 * Getter method for total characters count
	 * @return cCount
	 */
	public long getcCount() {
		return cCount;
	}
	
	/**
	 * Setter method for total character Count
	 * @param cCount
	 */
	public void setcCount(long cCount) {
		this.cCount = cCount;
	}
	
	/**
	 * Getter method for list of most frequently occured words.
	 * @return list of most frequently occured words
	 */
	public  List<String> getFreqWord() {
		return freqWord;
	}
	
	/**
	 * Setter method for list of most frequently occured words 
	 * @param freqWord
	 */
	public void setFreqWord(String freqWord) {
		this.freqWord.add(freqWord);
	}
	
	/**
	 * Method for clearing list of frequently occured words
	 */
	public void clearFreqWordList()
	{
		freqWord.clear();
	}
	
	/**
	 * Getter method count of most frequently occured word
	 * @return freqCount
	 */
	public long getFreqCount() {
		return freqCount;
	}
	
	/**
	 * Setter method count of most frequently occured word
	 * @param freqCount
	 */
	public void setFreqCount(long freqCount) {
		this.freqCount = freqCount;
	}
	
	
	/**
	 * Method to return Result object in proper format.
	 */
	public String toString()
	{
		String printRes="";
		String printList="";
		printRes+="The total number of words is:" + getwCount()+"\n";
		printRes+="The most frequently used word (is/are): ";
		for(String word :getFreqWord())
			printList+=word+" ";
		printRes+=printList+'\n';
		printRes+="The frequency of the most frequently used word is: "+getFreqCount()+"\n";
		printRes+="The number of characters (without whitespaces) is: " + getcCount()+"\n";
		return printRes;
	}

	
	
	

}
