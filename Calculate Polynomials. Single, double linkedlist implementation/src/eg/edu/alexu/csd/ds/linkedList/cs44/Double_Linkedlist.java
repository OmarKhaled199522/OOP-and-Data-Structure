package eg.edu.alexu.csd.ds.linkedList.cs44;

public class Double_Linkedlist implements MyLinkedList {

	private Node head = null;	
	private Node tail = null;
	
	@Override
	public void add(int index, Object element) {
		
		Node n = new Node();
		Node i = head;
		n.value = element;
		int link_size = size();
		if(index < 0 || index > link_size) {throw  new NullPointerException();}
		if(index == 0 && head == null){
			head = tail  = n;
		} else if (index == 0){
			n.next = head;
			head.prev = n;
			head = n;
			
		} else if (index > 0 && index <= link_size) {
		
			for(int j = 0; j < index - 1; j++) i = i.next;
			
			if(i == tail){
				n.prev = tail;
				tail.next = n;
				tail = n;
				
			} else {
			
				n.prev = i;
				n.next = i.next;
				i.next.prev = n;
				i.next = n;
			}
		}
	}
	@Override
	public void add(Object element) {
		
		Node n = new Node();
		n.value = element;
		if(head == null){
			head = tail = n;
		} else {
			
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
	}
	
	@Override
	public Object get(int index) {
		
		int link_size = size();
		if(index < 0 || index >= link_size) {throw  new NullPointerException();}	
		Node i = head;
		for(int j = 0; j < index ; j++)
			i = i.next;
		
		return i.value;
		
	}
	
	@Override
	public void set(int index, Object element) {
		
		Node i = head;
		int link_size = size();
		if(index < 0 || index >= link_size) {throw  new NullPointerException();}
		if(index >= 0 && index < link_size){
			
			for(int j = 0; j < index; j++) i = i.next;
			i.value = element;
		}
		
		
		
	}
	
	@Override
	public void clear() {
		head = tail = null;
		
	}
	
	@Override
	public boolean isEmpty() {
		
		if(head == tail  && head == null) return true;
		return false;
	}
	
	@Override
	public void remove(int index) {
		
		Node i = head;
		int link_size = size();
		if(index < 0 || index >= link_size) {throw  new NullPointerException();}
		
		if(i.next == null && index == 0) head = tail = null;
		else if (index == 0) {head = head.next; head.prev = null;}
		else {
			
			for(int j = 0; j < index - 1; j++) i = i.next;
			
			if(i.next == tail){
				i.next = null;
				tail = i;
				
			} else {
			
				Node e = i.next;
				i.next = e.next;
				e.next.prev = i;
				e.next = null;
				e.prev = null;	
			}
		}
	}
	
	@Override
	public int size() {
		
		if (head == null) return 0;
		Node i = head;
		int link_size = 1;
		while(i.next != null){
			i = i.next;
			link_size++;
		}
		return link_size;
		
	}
	
	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		
		int link_size = size();
		Double_Linkedlist l = new Double_Linkedlist();
		
		if(fromIndex < 0 || toIndex >= link_size) {throw  new NullPointerException();}
		Node i = head;
		
		for(int j = 0; j < fromIndex; j++){
			i = i.next;
		}
		l.add(i.value);
		for(int j = fromIndex; j < toIndex; j++){
			i = i.next;
			l.add(i.value);
		}
	
		return l;
	}
	
	@Override
	public boolean contains(Object o) {
		
		Node i = head;
		while(i.next != null){
			if (i.value.equals(o)) return true;
			i = i.next;
		}
		if(i.value.equals(o)) return true;
		return false;
	}
	
	public void print(){
		Node i = new Node();
		i = head;
		while(i != null){
			System.out.print(i.value + " ");
			i = i.next;
		}
	}	
}
