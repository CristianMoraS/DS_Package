package DoubleList;
import java.io.*;
public class ListD {
	Node head = null;
	/** -- EMPTY -- **/
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	/** -- INSERT -- **/
	public void insertAtBegin(Node newNode) {
		if(!isEmpty())
		{
			Node temp;
			temp = head;
			newNode.next = temp;
			head = newNode;
			temp.prev = head;
			head.prev = null;
		}else {
			head = newNode;
			newNode.next = null;
			newNode.prev = null;
		}
	}
	public void insertAtEnd(Node newNode) {
		if(!isEmpty())
		{
			Node temp;
			temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = null;
		}else {
			head = newNode;
			newNode.next = null;
			newNode.prev = null;
		}
	}
	/** -- DELETE -- **/
	public void deleteAtBegin() {
		Node temp = head;
		head = head.next;
		temp = null;
		System.gc();
	}
	public void deleteAtEnd() {
		Node temp = head;
		Node pre;
		while(temp.next.next != null )
		{
			temp = temp.next.next;
		}
		pre = temp.next;
		temp.prev = temp;
		temp.next = null;
		pre = null;
		System.gc();	
	}
	/** -- SIZE -- **/
	public void size() {
		Node temp = head;
		int count = 0;
		while(temp != null)
		{
			temp = temp.next;
			count++;
		}
		System.out.print("La lista tiene un tamaño de: " + count + "\n");
			
	}
	/** -- PRINT -- **/
	public void printListD() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Node temp = head;
		while(temp != null)
		{
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.flush();
	}
	public static void main(String[]args) throws IOException{
		ListD ld = new ListD();
		ld.insertAtBegin(new Node("Babitas"));
		ld.insertAtBegin(new Node("Lina"));
		ld.insertAtBegin(new Node("David"));
		ld.insertAtEnd(new Node("Gabriela"));
		ld.insertAtBegin(new Node("Evelyn"));
		ld.insertAtBegin(new Node("Cristian"));
		ld.insertAtBegin(new Node("Daniela"));
		ld.insertAtBegin(new Node("Maria"));
		ld.deleteAtEnd();
		ld.deleteAtBegin();
		ld.size();
		ld.printListD();
	}
}
