package eg.edu.alexu.csd.ds.queue.cs44;

public class Queue_array implements MyQueue {

	 private int last = 0;
	 private Object[] array;
	 
	 public Queue_array(int n){
	     array = new Object[n];
	 }
	 
	 public Queue_array(){
	      this(10);
	 }
	
	@Override
	public void enqueue(Object item) {
		if(last == array.length) throw new ArrayIndexOutOfBoundsException();
		array[last++] = item;
	}

	@Override
	public Object dequeue() {
		if(last == 0) throw new ArrayIndexOutOfBoundsException();
		
		Object temp = array[0];
		for(int i = 0; i < last - 1; i++){
			array[i] = array[i + 1];
		}
		last--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if(last == 0) return true;
		return false;
	}

	@Override
	public int size() {
		return  last;
	}

}
