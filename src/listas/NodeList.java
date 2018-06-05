package listas;

public class NodeList{
	// Atributos:
	public String name;
	public int age;
	public int id;
	
	//int* ponter = &a; en c/c++
	
	public NodeList next;// <--- Este es el puntero
	
	public NodeList() {}
	
	//nodo:
	public NodeList(String name, int age, int id) 
	{
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	// metodo to string
	public String toString()
	{
		return "Name: " + this.name + "\tAge:" + this.age + "\tId: " + this.id +"\n" ;
	}
	public NodeList clone() {
		NodeList clone = new NodeList(this.name,this.age,this.id);
		return clone;
	}
	
}
