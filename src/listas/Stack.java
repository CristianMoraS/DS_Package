package listas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack {
	
	NodeList head = null;//Empty List
	
	public boolean isEmpty()
	{
		// operador ternario.
		return head == null ? true : false;
	}
	
	public void push(NodeList newNode)
	{
		newNode.next = head;
		head = newNode;
	}
	
	public NodeList pop()
	{
		NodeList temp = head;
		head = head.next;
		temp = null;
		return temp;
	}
	public void printList() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		NodeList temp = head;
		while(temp != null)
		{
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.flush();
	}
}
