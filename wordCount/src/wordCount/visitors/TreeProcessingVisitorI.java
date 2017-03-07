package wordCount.visitors;

import wordCount.treesForStrings.BST;
/**
 * Interface for all visitors.
 * @author Rishi Sanas, Varun Kulkarni
 *
 */
public interface TreeProcessingVisitorI {
	public void visit(BST bst);
}
