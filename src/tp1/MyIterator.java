package tp1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{
	
	private Node<T> cursor; //cuando la lista implemente el iterador le va a indicar desde donde comentar a recorrer los elementos	

	public MyIterator(Node<T> cursor) {
		this.cursor = cursor;
	}

	//O(1) --> es constante, no importa cuantos elementos tenga la lista
	@Override
	public boolean hasNext() {
		return this.cursor != null; //si apunta a algun elemento.
	}

	
	//O(1) --> es constante, no importa cuantos elementos tenga la lista
	@Override
	public T next() {
		T info = this.cursor.getInfo(); //guardamos la info, porque cuando avanzamos la perdemos
		this.cursor = this.cursor.getNext();	
		
		return info;
	}
	
	//O(1) --> mueve un lugar
	public void moveNext() {
		this.cursor = this.cursor.getNext();
	}

		
	//O(1) --> hace una sola consulta
	public T get() {
		return this.cursor.getInfo();
	}
	
	public Integer getValue() {
		return (Integer) this.cursor.getInfo();
	}

}
