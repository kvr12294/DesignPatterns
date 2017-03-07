/*
 *  reads a line from the input file, and calls the insert(...) method of the BST
 *  
 */
package studentRecordsBackup.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
//import studentRecordsBackup.bst.Node;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;

public class BSTBuilder {
	public static FileInputStream f_stream;
	public static BufferedReader input;
	public static BST bst,backup1,backup2;

	public BSTBuilder(String fileName) {
		try {
			f_stream = new FileInputStream(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			input = new BufferedReader(new InputStreamReader(f_stream));
			readLineFromFile();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	void readLineFromFile() throws IOException {
		/*
		 * Method that reads line from an input file and makes three 
		 * instances of a BST Main Tree, Backup1 and Backup2 and 
		 * calls the function to insert in a BST
		 * 
		 */
		int num = 0;
		bst = new BST();
		backup1 = new BST();
		backup2 = new BST();
		
		String line = "";
		try {
			while ((line = input.readLine()) != null) {
				num = Integer.parseInt(line);
				Node mainnode = new Node(num);
				Node backupnode = new Node(num);
				Node backupnode2 = new Node(num);
				mainnode.addObserver(backupnode, new EvenFilterImpl());
				mainnode.addObserver(backupnode2, new OddFilterImpl());
				bst.insert(mainnode);
				backup1.insert(backupnode);
				backup2.insert(backupnode2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

