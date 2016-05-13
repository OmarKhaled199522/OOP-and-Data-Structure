package eg.edu.alexu.csd.ds.queue.cs44;

public class Node {

	private Object item;
	private Node next;
	private Node prev;
	
	public Object getElement() {
		return item;
	}
	public void setElement(Object element) {
		this.item = element;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
