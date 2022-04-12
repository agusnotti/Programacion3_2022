package tp1;

public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> previous;

	public Node() {
		this.info = null;
		this.next = null;
		this.previous = null;
	}
	
	public Node(T info, Node<T> next, Node<T> previous) {
		this.setInfo(info);
		this.setNext(next);
		this.setPrevious(previous);
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public Node<T> getPrevious() {
		return this.previous;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
}
