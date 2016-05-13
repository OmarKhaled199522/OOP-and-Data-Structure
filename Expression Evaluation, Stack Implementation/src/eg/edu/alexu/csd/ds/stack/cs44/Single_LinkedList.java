package eg.edu.alexu.csd.ds.stack.cs44;


public class Single_LinkedList implements MyStack {

	private Node head = null;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	@Override
	public void add(int index, Object element) {
		
		Node n = new Node();
		Node i = head;
		n.setElement(element);
		int link_size = size();
		if(index < 0 || index > link_size) {throw  new NullPointerException();}
		if(index == 0 && head == null){
			head = n;
		} else if (index == 0){
			n.setNext(head);
			head = n;
		} else if (index > 0 && index <= link_size) {
		
			for(int j = 0; j < index - 1; j++) i = i.getNext();
			n.setNext(i.getNext());
			i.setNext(n);;
		}	
	}

	@Override
	public Object pop() {
		
		if(head == null){
			throw new NullPointerException();
			
		} else {
			Object i = head.getElement();
			head = head.getNext();
			return i;
		}
	}

	@Override
	public Object peek() {
		
		if(head == null){
			throw new NullPointerException();
			
		} else {
			return head.getElement();
		}
	}

	@Override
	public void push(Object element) {
		
		Node n = new Node();
		n.setElement(element);
		
		if(head == null){
			head = n;
			n.setNext(null);
			
		} else {
			
			n.setNext(head);
			head = n;
		}
	}

	@Override
	public boolean isEmpty() {
		
		if(head == null) return true;
		return false;
	}

	@Override
	public int size() {
		
		if (head == null) return 0;
		Node i = head;
		int link_size = 1;
		while(i.getNext() != null){
			i = i.getNext();
			link_size++;
		}
		return link_size;
		
	}
}
