package tp2;

import java.util.ArrayList;

//con esta implementacion se considera que el arbol es una estructura que tiene subarboles (ESTRUCTURA RECURSIVA).
//Cada arbol tiene una referencia al subarbol derecho y al subarbol izquierdo.

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public void add(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.add(newValue);
			} else if (this.value < newValue) {
				if (this.right == null)
					this.right = new Tree(newValue);
				else
					this.right.add(newValue);
			}
		}
	}	
	
	//Devuelve el valor del elemento raiz
	public  Integer getRoot() {
		return 1;
	}
	
	/* Devuelve True si el algun nodo/subarbol contiene el elemento buscado (value)	*/
	public boolean hasElement(int value) {
		
		return false;
	}
	
	/*Si el arbol esta vacio, retorna True.
	*/
	public boolean isEmpty() {
		return true;
	}

	/**Eliminar un elemento. complicado */
	public boolean delete(int value){
		return false;
	}

    /** Retornar la altura del arbol --> Cantidad de arcos que tengo que pasar para llegar al nodo que esta mas lejos */
	public int getHeight(){
		return 1;
	}

	//RECORRIDO POSORDER --> izquierda, derecha, imprimo
	public void printPosOrder(){

	}

	//RECORRIDO PREORDER --> imprimo, izquierda, derecha
	public void printPreOrder(){
		
	}
	
	//RECORRIDO INORDER --> izquierda, imprimo, derecha
	public void printInOrder(){

	}
	
	//Rama mas larga --> Retorna una lista con los valores de la rama mas larga (h)
	public ArrayList<Integer> getLongestBranch(){
		return new ArrayList<Integer>();
	}

	//Hojas de izquiera a derecha --> Retorna una lista
	public ArrayList<Integer> getFrontera(){
		return new ArrayList<Integer>();
	}

	
	
	public int getMaxElem(){

		return 1;
	}


	public ArrayList<Integer> getElemAtLevel(){
		return new ArrayList<Integer>();
	}
	
}
