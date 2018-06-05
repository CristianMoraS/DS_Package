package LoopList;

public class Node {
	public String name;
	
	public Node next;
	
	public Node(String nam)
	{
		this.name = nam;
	}
	
	public String toString()
	{
		return "Nombre: " + this.name + "\n";
	}
	
	public Node cloner()
	{
		Node clone = new Node(this.name); 
		return clone;
	}
}
