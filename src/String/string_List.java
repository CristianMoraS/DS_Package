package String;
import java.io.*;
public class string_List {
	NodeString head = null;
	public boolean isEmpty() {
		return head == null ? true : false;
	}
	/** -- TAMAÑO -- **/
	public void tamaño(){
		int count = 0;
		NodeString temp = head;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		System.out.print("El tamaño es: ");
		System.out.print(count + "\n ");
	}
	
	/** -- CONTCATENACION -- **/
	public void concatenacion(NodeString newNode){
		if(isEmpty()) 
		{
			head = newNode;
		}else
		{
			NodeString temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	/** -- SUBCADENA -- **/
	public NodeString subcadena(){
		if(!isEmpty()) {
			string_List leftList = new string_List();
			string_List rightList = new string_List();
			 
			NodeString temp = head;
			NodeString sub = head.next;
			while(temp != null) {
				if(temp.next == null) {
					leftList.concatenacion(temp.clone());					
				}else {
					rightList.concatenacion(temp.clone());
				}
				sub.next = rightList.head;
				leftList.concatenacion(sub);
				head = leftList.head;
			}	
		}
		return null;
	}
	
	/** -- SPLIT -- **/
	public String[] split (char input){
        NodeString temp = head;
        int count = 0, cont = 0;
        
        while(temp.next != null){
            if(temp.character == input){
                count++;
            }
            temp = temp.next;            
        }
        String[] sp;
        
        sp = new String[count++];
        temp = head;
        
        while(temp.next != null){
            String aux =" ";
            while(temp.character != input && temp.next != null){
            	
                aux = aux + temp.character;
                if(temp.next != null) {
                    temp = temp.next;
                }    
                if(temp.next == null){
                    aux = aux + temp.character;
                }
            }
            sp[cont+1] = aux;
            
            if(temp.next != null) {
            	temp = temp.next;
            }
                
        }
        return sp;
    }
	
	/** -- PRINT -- **/
	public void print_List() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		NodeString temp = head;
		while(temp != null) {
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.flush();
	}
	
	/** -- MAIN -- **/
	public static void main(String[]arg) throws IOException {
		string_List sl = new string_List();
		try {
		sl.concatenacion(new NodeString('h'));
		sl.concatenacion(new NodeString('o'));
		sl.concatenacion(new NodeString('l'));
		sl.concatenacion(new NodeString('a'));

		sl.concatenacion(new NodeString('m'));
		sl.concatenacion(new NodeString('u'));
		sl.concatenacion(new NodeString('n'));
		sl.concatenacion(new NodeString('d'));
		sl.concatenacion(new NodeString('o'));
		sl.tamaño();
		
		sl.print_List();
		}catch(Exception ex) {
			
		}
	}
}
