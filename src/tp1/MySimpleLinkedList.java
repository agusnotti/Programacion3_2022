package tp1;

public class MySimpleLinkedList<T> {

	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size ++;
	}
	
	public T extractFront() {	
		T info = null; /// PREGUNTAR
		if(this.first != null) {
			info = this.first.getInfo();
			this.first = this.first.getNext();
			this.size --;
		}
		return info;
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	//DEBERIA RECORRERSE CON UN WHILE?
	/*public T get(int index) {
		Node<T> tmp = null;
		
		if(this.first != null && index <= this.size) {
			tmp = this.first;
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();  // en la ultima iteracion tmp es null porque no hay siguiente
			}
		}
		return tmp.getInfo();
	}*/
	
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
	
}
