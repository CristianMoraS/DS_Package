package Hash;

import java.util.Arrays;

public class TablaHash {

	String[] arreglo;
	int tam, cont;
	//Contructor
	public TablaHash(int ta) {
		tam = ta;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}
	
	//insertar
	public void insertar(String []cadena, String [] arreglo) {
		int i;
		for(i = 0; i < cadena.length; i++) {
			String elemento = cadena[i];
			int indexArr = Integer.parseInt(elemento) % 7;
			System.out.println("El indice es: " + indexArr +
					" Para el elemento o valor: " + elemento);
			//Solucionando colicion
			while(arreglo[indexArr] != "-1") {
				indexArr++;
				System.out.println("Ocurrio una colicion en el indice: " + (indexArr-1) + 
						" Cambiar al indice " + indexArr);
				indexArr %= tam;
			}
			arreglo[indexArr] = elemento;
		}
	}
	
	//Metodo para mostrar
	public void mostrar() {
		int incremento = 0, i, j;
		for (i = 0; i < 1; i++) {
			incremento += 8;
			for(j = 0; j < 71; j++) {
				System.out.print("-");
			}
			System.out.println();
			for(j = incremento - 8; j < incremento; j++) {
				System.out.format("| %3s" + " ", j);
			}
			System.out.println("|");
			for(int n = 0; n < 71; n++) {
				System.out.print("-");
			}
			System.out.println();
			for(j = incremento - 8; j < incremento; j++) {
				if(arreglo[j].equals("-1")) {
					System.out.print("|     ");
				}else {
					System.out.print(String.format("| %3s" + " ",arreglo));
				}
			}
			System.out.println("|");
			for(j = 0; j < 71; j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
	
	//main
	public static void main(String []args) {
		TablaHash hash = new TablaHash(8);
		String []elemento = {"20", "33", "2", "10", "12", "14", "56", "100"};
		hash.insertar(elemento, hash.arreglo);
		hash.mostrar();
	}	
}
