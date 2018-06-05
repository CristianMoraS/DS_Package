package listas;

/**
 *
 * @author Camilo Camargo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Queue {

    NodeList head = null;//Empty List

    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }

    public void enqueue(NodeList newNode) {
        newNode.next = head;
        head = newNode;
    }

    public NodeList dequeue() {
        NodeList temp = head;
        head = head.next;
        temp = null;
        return temp;
    }

    public void printStack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        NodeList temp = head;
        while (temp != null) {
            bw.write(temp.toString());
            temp = temp.next;
        }
        bw.flush();

    }
    
}
