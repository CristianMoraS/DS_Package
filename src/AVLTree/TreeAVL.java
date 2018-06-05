package AVLTree;



public class TreeAVL {
	Node root = null;
	//Buscar
	public Node buscar(int d, Node r) {
		if(root == null) {
			return null;
		}else if(r.data == d) {
			return r;
		}else if(r.data < d) {
			return buscar(d, r.left); 
		}else {
			return buscar(d, r.right);
		}
	}
	
	public Node obtenerRaiz() {
		return root;
	}
	
	//obtener factor de equilibrio
	public int fact(Node f) {
		if(f == null) {
			return -1;
		}else {
			return f.fact;
		}
	}
	//rotacion simple izquierda
	public Node rotacionIzquierda(Node n) {
		Node temp = n.left;
		n.left = temp.right;
		temp.right = n;
		n.fact = Math.max(fact(n.left), fact(n.right)) + 1;
		temp.fact = Math.max(fact(temp.left), fact(temp.right)) + 1;
		return temp;
	}
	//rotacion simple deracha
	public Node rotacionDerecha(Node n) {
		Node temp = n.right;
		n.right = temp.left;
		temp.left = n;
		n.fact = Math.max(fact(n.left), fact(n.right)) + 1;
		temp.fact = Math.max(fact(temp.left), fact(temp.right)) + 1;
		return temp;
	}
	//rotacion doble Izquierda
	public Node rotacionDobleIzq(Node n) {
		Node temp;
		n.left = rotacionDerecha(n.left);
		temp = rotacionIzquierda(n);
		return temp;
	}
	//rotacion doble Derecha
	public Node rotacionDobleDer(Node n) {
		Node temp;
		n.right = rotacionIzquierda(n.right);
		temp = rotacionDerecha(n);
		return temp;
	}
	//Metodo para insertar
	public Node balancear(Node nw,Node sub ) {
		Node newParent = sub;
		if(nw.data < sub.data) {
			if(sub.left == null) {
				sub.left = nw;
			}else {
				sub.left = balancear(nw, sub.left);
				if((fact(sub.left) - fact(sub.right)) == 2) {
					if(nw.data < sub.left.data) {
						newParent = rotacionIzquierda(sub);
					}else {
						newParent = rotacionDobleIzq(sub);
					}
				}
			}
		}else if(nw.data > sub.data) {
			if(sub.right == null) {
				sub.right = nw;
			}else {
				sub.right = balancear(nw, sub.right);
				if((fact(sub.right) - fact(sub.left)) == 2) {
					if(nw.data > sub.right.data) {
						newParent = rotacionDerecha(sub);
					}else {
						newParent = rotacionDobleDer(sub);
					}
				}
			}
		}else {
			System.out.println("Nodo Duplicado");
		}
		//Actualizar
		if((sub.left == null) && (sub.right != null)  ) {
			sub.fact = sub.right.fact + 1;
		}else if((sub.right == null) && (sub.left != null)) {
			sub.fact = sub.left.fact + 1;
		}else {
			sub.fact = Math.max(fact(sub.left), fact(sub.right)) + 1;
		}
		return newParent;
	}
	
	public void insertar(int d) {
		Node temp = new Node(d);
		if(root == null) {
			root = temp; 
		}else {
			root = balancear(temp, root);
		}
	}
	//recorridos
	public void inOrden(Node r) {
		if(r != null) {
			inOrden(r.left);
			System.out.println(r.data + "\n");
			inOrden(r.right);
		}
	}
	
	public void preOrden(Node r) {
		if(r != null) {
			System.out.println(r.data + "\n");
			preOrden(r.left);
			preOrden(r.right);
		}
	}
	
	public void posOrden(Node r) {
		if(r != null ) {
			posOrden(r.left);
			preOrden(r.right);
			System.out.println(r.data + "\n");
		}
	}
	
	public static void main(String []args) {
		TreeAVL tr = new TreeAVL();
		//Insertando
		tr.insertar(10);
		tr.insertar(5);
		tr.insertar(13);
		tr.insertar(1);
		tr.insertar(6);
		tr.insertar(17);
		tr.insertar(16);
		tr.preOrden(tr.obtenerRaiz());
	}
}
