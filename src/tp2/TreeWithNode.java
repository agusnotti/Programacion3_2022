package tp2;

//con esta implementacion se considera que el arbol es una estructura que tiene Nodos.
//Cada nodo del arbol tiene un valor, y referencias a su nodo izquierdo y a su nodo derecho.

import java.util.ArrayList;

public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public TreeWithNode(Integer value) {
		this.root = new TreeNode(value);
	}
	
	//Desde el metodo publico invoco a mi metodo privado
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	//Metodo privado para no romper el encapsulamiento. Desde fuera nadie sabe como esta implementado mi arbol.
	//No pueden tener acceso a los nodos directamente	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	//Devuelve el valor del elemento raiz
	public Integer getRoot() {
		
		return this.root.getValue();
	}
	
	/*Si el arbol esta vacio, retorna True.*/
	public boolean isEmpty() {
		
		return this.root == null;
	}
	
	
	/* Devuelve True si el algun nodo/subarbol contiene el elemento buscado (value)	*/
	public boolean hasElement(int value) {
		return hasElement(this.root, value);
	}
	
	private boolean hasElement(TreeNode node, int value) {		
		boolean hasElement = true;
		if(node == null) {
			hasElement = false;
		}else {			
			if(value == node.getValue()) {
				hasElement = true;
			} else if (value < node.getValue()) {
				hasElement = hasElement(node.getLeft(), value);
			} else {
				hasElement = hasElement(node.getRight(), value);
			}
		}
		
		return hasElement;
	}

    /** Retornar la altura del arbol --> Cantidad de arcos que tengo que pasar para llegar al nodo que esta mas lejos */
	//altura del nodo raíz
	
	public int getHeight() {
		return getHeight(this.root);
	}
	
	private int getHeight(TreeNode node){
		int heightLeft = -1;
	    int heightRight = -1;
	    
	    if(node.getLeft() != null) {
	    	heightLeft = getHeight(node.getLeft());
	    	System.out.println("heightLeft"+heightLeft);
	    }
	    if(node.getRight() != null) {
	    	heightRight = getHeight(node.getRight());
	    	System.out.println("heightRight"+heightRight);
	    }
	    
	    return Math.max(heightLeft, heightRight) + 1;
	}

	//RECORRIDO POSORDER --> izquierda, derecha, imprimo
	public void printPosOrder(){
		printPosOrder(this.root);
	}
	
	private void printPosOrder(TreeNode node) {
		if (node == null) {
			System.out.print(" - ");
		} else {
			printPosOrder(node.getLeft());
			printPosOrder(node.getRight());
			System.out.print(node.getValue()+" ");
		}
	}

	//RECORRIDO PREORDER --> imprimo, izquierda, derecha
	public void printPreOrder(){
		printPreOrder(this.root);
	}
	
	private void printPreOrder(TreeNode node){
		if (node == null) {
			System.out.print(" - ");
		} else {
			System.out.print(node.getValue()+" ");
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}
	
	//RECORRIDO INORDER --> izquierda, imprimo, derecha
	public void printInOrder(){
		printInOrder(this.root);
	}
	
	private void printInOrder(TreeNode node){
		if (node == null) {
			System.out.print(" - ");
		} else {
			printInOrder(node.getLeft());
			System.out.print(node.getValue()+" ");
			printInOrder(node.getRight());
		}
	}
	
	
	//NODO MAS DERECHO --> O(h) donde h es la altura del arbol
	public Integer getMaxElem(){

		return getMaxElem(this.root);
	}	
	
	private Integer getMaxElem(TreeNode node) {
		Integer maxElem = null;
		if(!this.isEmpty()) {
			if(node.getRight() != null) {
				maxElem = getMaxElem(node.getRight());
			} else {
				maxElem = node.getValue();
			}
		}		
				
		return maxElem;
	}
	

	//Hojas de izquiera a derecha --> Retorna una lista
	public ArrayList<Integer> getFrontera(){
		return getFrontera(this.root,new ArrayList<Integer>());
	}
	
	private ArrayList<Integer> getFrontera( TreeNode node, ArrayList<Integer> list) {
		if(!this.isEmpty()){			
			if(node.getLeft() == null && node.getRight() == null) {
				list.add(node.getValue());
			} 
			
			if(node.getLeft() != null) {
				getFrontera(node.getLeft(),list);
			}
			
			if(node.getRight() != null) {
				getFrontera(node.getRight(),list);
			}
			
        }
		return list;
	}	
	
	//Rama mas larga --> Retorna una lista con los valores de la rama mas larga (h)
	public ArrayList<Integer> getLongestBranch(){
		return new ArrayList<Integer>();
		
	}

	//Le paso un nivel por parametro y me tiene que retornar una lista con los valores que se encuentran en ese nivel
	public ArrayList<Integer> getElemAtLevel(){
		return new ArrayList<Integer>();
	}
	

	/**Eliminar un elemento. complicado */
	public boolean delete(int value){
		return false;
	}
	
	
}
