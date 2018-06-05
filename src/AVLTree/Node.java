package AVLTree;

public class Node {
	int data, fact;
	
	Node left, right;
	
	public Node(int d) {
		this.data = d;
		this.fact = 0;
		this.left = null;
		this.right = null;
	}
	
	public String toString() {
		return this.data + "\n";
	}
}
