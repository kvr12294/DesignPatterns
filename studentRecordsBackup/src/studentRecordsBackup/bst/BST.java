/*
 * class BST has methods to insert in BST, Print the BST in inorder 
 * fashion.
 * It also has method to Update main BST and update max node of main BST
 */
package studentRecordsBackup.bst;

public class BST {
	private Node node1, node2, node3;
	private Node root;
	private Node max;
	private int sum;

	public BST() {
		root = null;
		max = new Node(0);
		sum = 0;
	}

	public void insert(Node n) {
		root = insert(root, n);
	}

	public Node insert(Node node, Node d) {
		//Method to Insert a Node into BST
		if (node == null)
			node = d;
		else {
			if (d.data <= node.getdata())
				node.left = insert(node.left, d);
			else
				node.right = insert(node.right, d);
		}
		return node;
	}

	public void printInorder() {
		printInorder(root);
		System.out.println();
	}

	private void printInorder(Node root) {
		//Method to traverse a tree in Inorder Fashion
		if (root != null) {
			printInorder(root.getleft());
			System.out.print(root.getdata() + " ");
			printInorder(root.getright());
			if (root.getdata() >= max.getdata()) {
				max.setdata(root.getdata());
			}
		}
	}

	public void updateNode(int updateValue) {
		updateBst(root, updateValue);
	}

	public int findmax() {
		return max.getdata();
	}

	public void update_max(int updateValue){
		update_max(root, updateValue);
	}
	public void update_max(Node root, int updateValue) {
		//Method to update Max node of a main BST
		if (root != null) {
			if (max.getdata() == root.getdata()) {
				root.setdata(root.getdata() + updateValue);
			} else
				update_max(root.getright(), updateValue);
		}
	}

	public void updateBst(Node r, int updateValue) {
		//Method to Update Main BST with UPDATE_VALUE
		if (r != null) {
			updateBst(r.getleft(), updateValue);
			r.update(updateValue);
			r.notifyObservers(updateValue);
			updateBst(r.getright(), updateValue);
		}
	}
	
	public int printBsum() {
		sum = 0;
		//System.out.println("sum before calculating "+sum);
		calc_sum(root);
		return sum;
	}
	public void calc_sum(Node root){
		if(root != null){
			calc_sum(root.getleft());
			sum += root.getdata();
			calc_sum(root.getright());
		}
	}
}
