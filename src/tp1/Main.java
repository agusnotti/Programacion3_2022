package tp1;

public class Main {

	public static void main(String[] args) {

		MySimpleLinkedList<String> msl = new MySimpleLinkedList<String>();
		
		//Node<String> n1 = new Node<String>("A", null);
		//Node<String> n2 = new Node<String>("B", n1);
		//Node<String> n3 = new Node<String>("C", n2);
		
		
		msl.insertFront("A");
		msl.insertFront("B");
		msl.insertFront("C");
		
		//System.out.println("get "+msl.get(0));
		//System.out.println("get "+msl.get(1));
		//System.out.println("get "+msl.get(2));
		System.out.println("get "+msl.get(2)); //rompe
		
		System.out.println("IndexOf "+msl.indexOf("B"));
		System.out.println("IndexOf "+msl.indexOf("A"));
		System.out.println("IndexOf "+msl.indexOf("C"));
		System.out.println("IndexOf "+msl.indexOf("D"));
		
		
		System.out.println(msl.toString());
		
	}

}
