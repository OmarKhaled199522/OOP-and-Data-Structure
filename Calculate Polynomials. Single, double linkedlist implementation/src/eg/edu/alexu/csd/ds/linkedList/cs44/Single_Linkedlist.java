package eg.edu.alexu.csd.ds.linkedList.cs44;

import java.util.Arrays;

public class Single_Linkedlist implements MyLinkedList {

	private Node head = null;
	
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	@Override
	public void add(int index, Object element){
		
		Node n = new Node();
		Node i = head;
		n.value = element;
		int link_size = size();
		if(index < 0 || index > link_size) {throw  new NullPointerException();}
		if(index == 0 && head == null){
			head = n;
		} else if (index == 0){
			n.next = head;
			head = n;
		} else if (index > 0 && index <= link_size) {
		
			for(int j = 0; j < index - 1; j++) i = i.next;
			n.next = i.next;
			i.next = n;
		}
	}
	
	@Override
	public void add(Object element){
		
		Node n = new Node();
		Node i = new Node();
		i = head;
		n.value = element;
		
		if (head == null){
			head = n;
			
		} else {
			
			while( i.next != null){
				i = i.next;
			}
			i.next = n;
		}
		 n.next = null;
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
		
		Node n = new Node();
		n.value = element;
		Node i = head;
		int link_size = size();
		if(index < 0 || index > link_size) {throw  new NullPointerException();}
		if(index >= 0 && (index < link_size || index == 0)){
			if(head == null && index == 0){
				head = n;
			} else if (index == 0){
				n.next = i.next;
				head = n;
			} else {
				for(int j = 0; j < index - 1; j++){
					i = i.next;
				} 
					n.next = i.next.next;
					i.next = n;
			}
		}
	}

	@Override
	public void clear() {
		head = null;
		
	}

	@Override
	public boolean isEmpty() {
		
		if(head == null) return true;
		return false;
	}

	@Override
	public void remove(int index) {
			
			Node i = head;
			int link_size = size();
			if(index < 0 || index >= link_size) {throw  new NullPointerException();}
			if(i.next == null && index == 0) head = null;
			else if (index == 0) head = head.next;
			else {
				
				for(int j = 0; j < index - 1; j++) i = i.next;
				Node e = i.next;
				i.next = e.next;
				e.next = null;
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
		Single_Linkedlist l = new Single_Linkedlist();
		if(fromIndex < 0 || toIndex >= link_size)  {throw  new NullPointerException();}
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
			if (i.value.equals(o) ) return true;
			i = i.next;
		}
		if(i.value.equals(o)) return true;
		return false;
	}
	
	public Single_Linkedlist  copy(Single_Linkedlist cop){
		
		Node i = head;
		
		while(i != null){
			cop.add(i.value);
			i = i.next;
		}
		cop.head = head;
		return cop;
		
	}
	
	
	
	
	
	
	public void print(){
		Node i = new Node();
		i = head;
		Magnitude n = new Magnitude();
		while(i != null){
			n = (Magnitude) i.value;
			System.out.print(n.coeff + "   "+ n.expon + " ");
			i = i.next;
		}
	}
	
	public void sort_short(){
		
		int [] arr = new int [50];
		int length = 0;
		
		/*while(i.next != null){
			j = i.next;
			n = (Magnitude) i.value;
			
			while(j.next != null){
				
				m = (Magnitude) j.value;
				if(n.expon < m.expon){
					temp1 = n.expon;
					temp2 = n.coeff;
					n.expon = m.expon;
					n.coeff = m.coeff;
					m.expon = temp1;
					m.coeff = temp2;
				}
				j = j.next;
			}
			i = i.next;
		}*/
		
		Node b = head;
		Node r = head;
		
		for(int g = 0; b.next != null; b = b.next, g++){
			r = b.next;
			Magnitude c = (Magnitude) b.value;
			
			for(int k = g + 1; r != null; r = r.next, k++){
				Magnitude v = (Magnitude) r.value;
				
				if(c.expon == v.expon){
					arr[length] = k;
					length++;
					c.coeff += v.coeff;
					v.coeff = 0;
					//b = b.next;
				}
			}
			b.value = c;
		}
		

		Arrays.sort( arr );
		
		for(int f = arr.length - 1; length > 0; length--, f--){
			remove(arr[f]);
			
		}
	}
	
	public void print_variable(){
		
		int found = 0;
		Node i = head;
		while(i != null){
			Magnitude n = (Magnitude) i.value;
			if(n.coeff != 0 && n.expon != 0){
				if(i == head || n.coeff < 0){found = 1;System.out.printf("%.2fX ^ %.2f ", n.coeff , n.expon);}
				else if(n.coeff > 0) {System.out.printf("+%.2fX ^ %.2f ", n.coeff , n.expon); found = 1;}
			}
			else if(n.coeff != 0 && n.expon == 0){
				if(i == head || n.coeff < 0){ System.out.printf("%.2f ", n.coeff); found = 1;}
				else if(n.coeff > 0){ System.out.printf("+%.2f ", n.coeff); found = 1;}
			}
			i = i.next;
		}
		if(found == 0) System.out.print(0);
		System.out.println();
	}
}
