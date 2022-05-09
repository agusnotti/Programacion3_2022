package tp1;

//import java.util.Iterator;

//a partir del esqueleto de la lista vinculada simple, hice la doblemente vinculada

public class MySimpleLinkedList<T> implements Iterable<T>{

	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public Node<T> getFirst(){
		return this.first;
	}
	
	public Node<T> getLast(){
		return this.last;
	}
	
	//O(1) complejidad constante, no depende del tamaño de la lista
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null,null);
		tmp.setNext(this.first);
		if(this.isEmpty()) {
			this.last = tmp;
		} else {
			this.first.setPrevious(tmp);
		}
		this.first = tmp;
		this.size ++;
	}	
	
	public void insertLast(T info) {
		Node<T> tmp = new Node<T>(info, null, this.last);
		if(this.isEmpty()) {
			this.first = tmp;
		} else {
			this.last.setNext(tmp);
		}
		this.last = tmp;
		this.size++;
	}
	
	
	//O(1) complejidad constante, no depende del tamaño de la lista
	public T extractFront() {	
		T info = null;
		if(this.first != null) {
			info = this.first.getInfo();
			this.first = this.first.getNext();
			this.size --;
		}
		return info;
	}
	
	public T extractLast() {	
		T info = null;
		if(!this.isEmpty()) {
			info = this.last.getInfo();
			this.last = this.last.getPrevious();
			this.last.setNext(null);
			this.size --;
		}
		return info;
	}

	//O(1) complejidad constante, no depende del tamaño de la lista, es una sola consulta
	public boolean isEmpty() {
		return this.size == 0;
		//return this.first == null;
	}
	
	//DEBERIA RECORRERSE CON UN WHILE?
	//O(n) en el peor de los casos se recorren n elementos, siendo n el tamanio de la lista
	public T get(int index) {
		Node<T> tmp = null;
		int contador = 0;
		T info = null;
			
		if(this.first != null) {
			tmp = this.first;
			while (contador < index && tmp.getNext() != null) {
				tmp = tmp.getNext();
				contador ++;
			}
			
			if(index == contador) {
				info = tmp.getInfo();				
			}
		}
		return info;
	}	
	
	//O(1) complejidad constante, no depende del tamaño de la lista, es una sola consulta
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String info = "";
		Node<T> tmp = null;
		if(this.first != null) {
			tmp = this.first;
			for (int i = 0; i < this.size; i++) {
				info += tmp.getInfo().toString() + ",";
				tmp = tmp.getNext();
			}
		}
		return info;
	}
	
	
	/**
	 EJERCICIO 4: Agregar un metodo indexOf, que reciba un elemento y retorne el indice donde esta almacenado ese elemento
	 o -1 si no lo encuentra
	**/	
	//O(n) en el peor de los casos recorre toda la lista buscando el elemento
	public int indexOf(T info) {
		Node<T> tmp = null;
		int index = -1;
		int contador = 0;
		
		if(this.first != null) {
			tmp = this.first;
			while (info != tmp.getInfo() && tmp.getNext() != null) {
				tmp = tmp.getNext();
				contador ++;
			}
			
			if(info == tmp.getInfo()) {
				index = contador;
			}
		}		
		return index;
	}
	
	
	//O(n) donde n el tamanio de la lista
    public MySimpleLinkedList<T> reverseList() {
    	MyIterator<T> it = this.iterator();
    	MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
    	
    	//O(n) * O(1) -> O(n) donde n es el tamanio de la lista
    	while (it.hasNext()) {
    		aux.insertFront(it.next()); //O(1)
    	}
    	
    	return aux;
    }	

	//retorna un iterador
	@Override
	public MyIterator<T> iterator() {
		return new MyIterator<T>(this.first); ///la lista le indica al iterador desde donde comenzar
	}
	
}
