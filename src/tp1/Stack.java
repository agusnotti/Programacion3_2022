package tp1;

public class Stack<T> {

	private MySimpleLinkedList<T> myList;

	public Stack() {
		this.myList = new MySimpleLinkedList<T>();
	}
	
	//O(1)
	//metodo push--> AGREGAR ELEMENTO (apilar)
	public void push(T info) {
		this.myList.insertFront(info);
	}
	
	//O(1)
	//metodo pop--> ELIMINAR ELEMENTO (desapilar)
	public T pop() {
		T info = null;
		if(!this.myList.isEmpty()) {
			info = this.myList.extractFront();
		}
		return info;
	}
	
	//O(1) (aunque el metodo get() sea O(n), en este caso no importa)
	//metodo top --> consulta el tope de la pila, sin eliminarlo.
	public T top() {
		T info = null;
		if(!this.myList.isEmpty()) {
			info = this.myList.get(0);
		}
		return info;
	}
	
	//O(n), n es el tamaño de la pila
	//metodo reverse --> invertir elementos
	public void reverse() {
		MySimpleLinkedList<T> aux = new MySimpleLinkedList<T>();
		T info = null;
		while(!this.myList.isEmpty()) {			
			info = this.myList.extractFront();
			aux.insertFront(info);
		}
		myList = aux;
	}
	
	
	public String toString() {		
		return this.myList.toString();
	}
	
	
}
