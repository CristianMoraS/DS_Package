package String;

public class NodeString {
	public char character;
	
	public NodeString next;
	
	public NodeString(char caracter) {
		this.character = caracter;
	}
	
	public String toString() {
		return " " + this.character;
	}
	
	public NodeString clone() {
		NodeString clone = new NodeString(this.character);
		return clone;
	}
}
