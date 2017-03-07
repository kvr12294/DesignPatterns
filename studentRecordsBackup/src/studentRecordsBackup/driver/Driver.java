/*
 * Driver Code:
 * Reads the command line arguments...validates them.
 * Creates instant of class BSTBuilder calls methods to print three
 * BST's and the sum of all the nodes of the BST's.
 */

package studentRecordsBackup.driver;

import studentRecordsBackup.bst.Node;
import studentRecordsBackup.bst.BST;
import studentRecordsBackup.util.BSTBuilder;

/**
 * @author Varun Kulkarni
 *
 */
public class Driver {
	public static void main(String args[]) throws Exception {
		if (args.length != 2) {
			System.err.println("Too Few arguments");
			System.exit(1);
		}
		int UPDATE_VALUE = 0;
		try {
			UPDATE_VALUE = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Creates Instant of BSTBuilder
		 */
		BSTBuilder BST_build = new BSTBuilder(args[0]); 
		System.out.println("Main Tree:-");
		BST_build.bst.printInorder();
		System.out.println("\nBackup 1:-");
		BST_build.backup1.printInorder();
		System.out.println("\nBackup 2:-");
		BST_build.backup2.printInorder();
		System.out.println("\nSum of all nodes of Main tree:-");
		System.out.print(BST_build.bst.printBsum());
		System.out.println("\nSum of all nodes of Backup 1 tree:-");
		System.out.print(BST_build.backup1.printBsum());
		System.out.println("\nSum of all nodes of Backup 2 tree:-");
		System.out.println(BST_build.backup2.printBsum());
		BST_build.bst.updateNode(UPDATE_VALUE);
		
		System.out.println("Main Tree:-");
		BST_build.bst.printInorder();	
		
		BST_build.bst.findmax(); // Method call for finding max value
		BST_build.bst.update_max(UPDATE_VALUE);
		System.out.println("\nFinal Main tree");
		BST_build.bst.printInorder();
		System.out.println("\nBackup 1:-");
		BST_build.backup1.printInorder();
		System.out.println("\nBackup 2:-");
		BST_build.backup2.printInorder();
		System.out.println("\nSum of all nodes of Main tree:-");
		System.out.print(BST_build.bst.printBsum());
		System.out.println("\nSum of all nodes of Backup 1 tree:-");
		System.out.print(BST_build.backup1.printBsum());
		System.out.println("\nSum of all nodes of Backup 2 tree:-");
		System.out.println(BST_build.backup2.printBsum());	
	} // end main(...)

} // end public class Driver
