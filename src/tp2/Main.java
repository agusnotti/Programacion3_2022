package tp2;

public class Main {

	public static void main(String[] args) {


		TreeWithNode abb = new TreeWithNode();
		
		abb.add(6);
		abb.add(3);
		abb.add(7);
		abb.add(1);
		abb.add(5);
		abb.add(4);
		abb.add(9);
		
		System.out.println("ROOT "+abb.getRoot());
		
		abb.printPreOrder(); //6 3 1  -  - 5 4  -  -  - 7  - 9  -  -
		System.out.println("\n");
		abb.printPosOrder(); //- - 1 - - 4 - 5 3 - - - 9 7 6
		System.out.println("\n");
		abb.printInOrder(); // - 1 - 3 - 4 - 5 - 6 - 7 - 9 -
		System.out.println("\n");
		System.out.println("hasElement: "+abb.hasElement(5));
		System.out.println("hasElement: "+abb.hasElement(8));

		System.out.println("HEIGHT: "+abb.getHeight());
		
		System.out.println("MAX ELEM: "+abb.getMaxElem());
		
		System.out.println("FRONTERA: "+abb.getFrontera());
		
		/*
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {5,2,3,4,1};
		int[] arr3 = {1,2,3,5,4};
		int[] arr4 = {1,2,3,5,5};
		int[] arr5 = {1,2,3,3,5};
		
		
		if(estaOrdenado(arr1,0)) {
			System.out.println("arr1 esta ordenado");
		} else {
			System.out.println("arr1 No esta ordenado");
		}
		
		
		if(estaOrdenado(arr2,0)) {
			System.out.println("arr2 esta ordenado");
		} else {
			System.out.println("arr2 No esta ordenado");
		}
		
		if(estaOrdenado(arr3,0)) {
			System.out.println("arr3 esta ordenado");
		} else {
			System.out.println("arr3 No esta ordenado");
		}
		
		if(estaOrdenado(arr4,0)) {
			System.out.println("arr4 esta ordenado");
		} else {
			System.out.println("arr4 No esta ordenado");
		}
		
		if(estaOrdenado(arr5,0)) {
			System.out.println("arr5 esta ordenado");
		} else {
			System.out.println("arr5 No esta ordenado");
		}
		*/
	}
	
	//EJERCICIO 1: IMPLEMENTAR UN METODO RECURSIVO QUE DETERMINE SIUN ARREGLO ESTA ORDENADO
	//O(n)
	public static boolean estaOrdenado(int[] arr, int index) {
		boolean estaOrdenado = true;
		if(index+1 < arr.length) {
			if(arr[index] <= arr[index +1]) {
				estaOrdenado = estaOrdenado(arr, index+1);
			} else {
				estaOrdenado = false;
			}
		}
		
		return estaOrdenado;
	}
	
	
	
}

// 1-2-3-4-5 (5)
// 0-1-2-3-4