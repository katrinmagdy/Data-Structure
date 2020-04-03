package eg.edu.alexu.csd.datastructure.stack;

public class Node {
	private Object element;
	private Node next;

	public Node() {
		this(null,null);
	}
	
	/**
	 * creates a node with Object s and next node n
	 * @param s object in the node
	 * @param n next node
	 */
	
	public Node (Object s ,Node n) {
		element=s;
		next=n;
	}
	
	/**
	 * 
	 * @return the element of the node
	 */
	
	public Object getElement() { return element; }
	
	/**
	 * 
	 * @return the next node
	 */
	
	public Node getNext() { return next; }
	
	/**
	 * sets the element of the node with  newElem
	 * @param newElem the new element
	 */
	
	public void setElement(Object newElem) {element = newElem;}
	
	/**
	 * sets the next of the node with newNext
	 * @param newNext the new next node
	 */
	
	public void setNext(Node newNext) { next = newNext; }
	

}
