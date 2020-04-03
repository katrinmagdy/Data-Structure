package eg.edu.alexu.csd.datastructure.stack;

public class ListStack implements IStack {
	private Node top;
	private int size;
	
	public ListStack() {
		top=null;
		size =0;
	}
	
	public Object pop() {
		Object temp;
			if(isEmpty()==true) {
				throw new RuntimeException("The Stack is Empty");
			  }
			else {
				temp=top.getElement();
				top=top.getNext();
				size--;
				return temp;
			}
	}
	
	public Object peek() {
		
			if(isEmpty()==true) {
				throw new RuntimeException("The Stack is Empty");
			  }
			else {
				return top.getElement();
			}
	}
	
	public void push(Object element) {
		Node v =new Node(element,top);
		top=v;
		size++;
	}
	
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}

}
