package Arbol;

public class Node {
	int value;
	
	public Node left;
	public Node right;
	
	public Node(int val) {
		this.value = val;
	}
	
	public String toString() {
		return "Valor: " + this.value + "\n";
	}
}
