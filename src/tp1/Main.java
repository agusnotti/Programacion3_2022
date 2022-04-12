package tp1;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		MySimpleLinkedList<String> msl = new MySimpleLinkedList<String>();		
		
		msl.insertFront("A");
		msl.insertFront("B");
		msl.insertFront("C");
		msl.insertFront("D");
		msl.insertFront("E");
		msl.insertFront("F");
		msl.insertFront("G");
		
		
		
		System.out.println("Size: "+msl.size());
		
		System.out.println("get "+msl.get(0));
		System.out.println("get "+msl.get(1));
		System.out.println("get "+msl.get(2));
		System.out.println("get "+msl.get(3));
		
		System.out.println(msl.toString());
		System.out.println("First: "+msl.getFirst().getInfo());
		System.out.println("Last: "+msl.getLast().getInfo());
		
		System.out.println("Extract last "+msl.extractLast());
		
		System.out.println("Last: "+msl.getLast().getInfo());
		
		msl.extractFront();	
		
		System.out.println(msl.toString());	
		
		
		//EJERCICIO 4
		System.out.println("IndexOf "+msl.indexOf("B"));
		System.out.println("IndexOf "+msl.indexOf("A"));
		System.out.println("IndexOf "+msl.indexOf("C"));
		System.out.println("IndexOf "+msl.indexOf("D"));
		
		
		
		System.out.println("PILA");
		
		Stack<String> pila = new Stack<String>();
		
		pila.push("aa");
		pila.push("ab");
		pila.push("ac");
		pila.push("ad");
		
		
		System.out.println(pila.toString());
		
		System.out.println("PILA REVERSA");
		pila.reverse();
		
		System.out.println(pila.toString());
		
		
		//EJERCICIO 5: LISTA ITERABLE
		Iterator<String> it = msl.iterator();
		
		System.out.println("Lista iterable: while");
		//VENTAJA DE USAR ITERADORES --> mayor eficiencia y menos complejidad
		
		//O(n) donde n es el tamaño de la lista
		while(it.hasNext()) {  
			String info = it.next();
			System.out.println(info);
		}
		
		//O(n^2)		
		for (int i = 0; i < msl.size(); i++) { //O(n)
			String info = msl.get(i); // el metodo get es O(n)
			System.out.println(info);
		}
		
		//para usar esta estructura la estructura que se quiere recorrer tiene que ser iterable
		System.out.println("Lista iterable: foreach");
		for (String info : msl) {
			System.out.println(info);
		}
		
		
		//EJERCICIO 6. LISTA DE INTEGERS
		
		MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<Integer>();
		
		lista1.insertFront(5);
		lista1.insertFront(1);
		lista1.insertFront(3);
		lista1.insertFront(4);
		lista1.insertFront(2);
		//1-2-3-4-5
		
		MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
		
		lista2.insertFront(6);
		lista2.insertFront(1);
		lista2.insertFront(3);
		lista2.insertFront(7);
		lista2.insertFront(2);
		
		//1-2-3-6-7
		
		ordenarListaAsc(lista1); //O(n^2)
		ordenarListaAsc(lista2); //O(n^2)
		
		MySimpleLinkedList<Integer> listaSalida = obtenerElementosComunes(lista1, lista2);
		
		System.out.println("Lista salida ");
		for (Integer info : listaSalida) {
			System.out.println(info);
		}
		
		MySimpleLinkedList<Integer> listaSalida2 = obtenerElementosExistentes(lista1, lista2);
		
		System.out.println("Lista salida 2");
		for (Integer info : listaSalida2) {
			System.out.println(info);
		}
		
		
			
		//EJERCICIO 9
		System.out.println(esCapicua("hola"));
		System.out.println(esCapicua("neuquen"));	
		
	}
	
	/*
	Ejercicio 6.Escriba un procedimiento que dadas dos listas construya otra con los elementos 
	comunes, suponiendo que: 
	a) Las listas están desordenadas y la lista resultante debe quedar ordenada. 
	
	for(n elementos de mi lista1) //O(n^2)
		buscar(e, lista2)		
	ordenar lista resultante //O(n^2) ?
	
	b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
	*/
	
	
	//O(n)
	public static MySimpleLinkedList<Integer> obtenerElementosComunes(MySimpleLinkedList<Integer>l1, MySimpleLinkedList<Integer>l2) {
		
		MyIterator<Integer> it1 = l1.iterator();
		MyIterator<Integer> it2 = l2.iterator();
		
		MySimpleLinkedList<Integer> listaSalida = new MySimpleLinkedList<Integer>();
		
		while(it1.hasNext() && it2.hasNext()) {
			if(it1.getValue() < it2.getValue()) {
				it1.moveNext(); 
			} else if(it2.getValue() < it1.getValue()) {
				it2.moveNext();
			} else if((it1.getValue())==it2.getValue()) {
				int valor = it1.getValue();
				listaSalida.insertFront(valor);
				it1.moveNext();
				it2.moveNext();					
			}
		}		
		return listaSalida;
	}
	
	
	//O(n^2)
	public static void ordenarListaAsc(MySimpleLinkedList<Integer> lista) {
		Node<Integer> actual = lista.getFirst();
		Node<Integer> indice = null; 
		int aux = 0;
		
		if(!lista.isEmpty() && lista.size() > 1) {
			for (int i = 0; i < lista.size()-1; i++) {
				indice = actual.getNext();
				for (int j = i+1; j < lista.size(); j++) {
					if(actual.getInfo() > indice.getInfo()) {
						aux = actual.getInfo();
						actual.setInfo(indice.getInfo());
						indice.setInfo(aux);
					}
					indice = indice.getNext();
				}
				actual = actual.getNext();
			}
		}
	}
	
	/*EJERCICIO 7. Escribir una funcion que dadas dos listas, construya otra con los 
	elementos que estan en la primera pero no en la segunda*/
	
	//O(n^2)
	public static MySimpleLinkedList<Integer> obtenerElementosExistentes(MySimpleLinkedList<Integer>l1, MySimpleLinkedList<Integer>l2) {
		
		MyIterator<Integer> it1 = l1.iterator();
		
		MySimpleLinkedList<Integer> listaSalida = new MySimpleLinkedList<Integer>();
		
		while(it1.hasNext()) {
			if(l2.indexOf(it1.getValue()) != -1){ //metodo indexOf --> O(n)
				listaSalida.insertFront(it1.getValue());
			}
			it1.moveNext();
		}		
		return listaSalida;
	}
	
	
	
	
	//Ejercicio 9. Verificar si una cadena de texto es palindroma (capicua).
	//O(log2n)
	public static boolean esCapicua(String cadena) {
		int size = cadena.length();
		//int ini = 0;
		int fin = size-1;
		boolean esCapicua = true;
		
		for (int i = 0; i < Math.floor(size/2); i++) {
			if(cadena.charAt(i) == cadena.charAt(fin)) {				
				fin--;
			} else {
				esCapicua = false;
				break;
			}
		}
		
		return esCapicua;
	}

}
