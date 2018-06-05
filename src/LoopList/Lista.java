package LoopList;

import java.io.*;

public class Lista {
	
	Node head = null;
	
	public boolean isEmpty() {		
		return head == null ? true : false;
	}
	
	/** -- INSERT -- **/
	public void insertAtBegin(Node newNode) {
		if(isEmpty())
		{
			newNode.next = head;
			head = newNode;
			head.next = head;
		}else {
			Node temp = head;
			newNode.next = temp;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
			head = newNode;
		}
	}
	public void insertAtEnd(Node newNode) {
		if(isEmpty())
		{
			newNode.next = head;
			head = newNode;
			head.next = head;
		}else{
			Node temp = head;
			while(temp.next != head)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}
	}
	public void insertAtIndex(Node newNode,int index) {
		
	}
	
	/** -- DELETE -- **/
	public void deleteAtBegin(){
		if(!isEmpty())
		{
			Node temp = head;
			Node aux = temp.next;
			while(temp.next != head)
			{
				temp = temp.next;
			}
			temp.next = aux;
			temp = null;
			head = aux;
			System.gc();
		}
	}
	public void deleteAtEnd(){
		if(!isEmpty())
		{
			Node temp;
			Node pre = head;
			while(pre.next.next != head)
			{
				pre = pre.next;
			}
			temp = pre.next;
			pre.next = head;
			temp = null;
			System.gc();
		}
	}
	
	/** -- Size -- **//*-- TIENE PROBLAMAS --*/
	public void sizeList() {
		Node temp = head;
		int count = 0;
		while(temp.next != head)
		{
			count++;
			temp = temp.next;
		}
	}
	/** -- PRINT -- **/
	public void printList() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(!isEmpty())
		{
			Node temp = head;
			do {
				bw.write(temp.toString());
				temp = temp.next;
			}while(temp != head);
			bw.flush();
		}
    }
	
	
	public static void main(String[]args) throws IOException {
		Lista ls = new Lista();
		ls.insertAtEnd(new Node("Cristian"));
		ls.insertAtBegin(new Node("David"));
		ls.insertAtEnd(new Node("Maria"));
		ls.insertAtBegin(new Node("Paula"));
		ls.insertAtEnd(new Node("Lina"));
		ls.insertAtBegin(new Node("Gabriela"));
		ls.insertAtEnd(new Node("Evelyn"));
		ls.insertAtBegin(new Node("Babitas"));
		ls.deleteAtBegin();
		ls.deleteAtEnd();
		ls.printList();
	}
	
}
