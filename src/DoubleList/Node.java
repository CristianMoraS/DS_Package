package DoubleList;

public class Node {
	public String name;
	
	public Node next;
	public Node prev;
	
	public Node(String n) {
		this.name = n;
	}
	
	public String toString()
	{
		return "Nombre: " + this.name + "\n";
	}
}
