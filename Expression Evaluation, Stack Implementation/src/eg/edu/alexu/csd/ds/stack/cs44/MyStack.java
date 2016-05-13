package eg.edu.alexu.csd.ds.stack.cs44;

public interface MyStack {

	public void add(int index  , Object element);
	 
	public Object pop(); 	 
	
	public Object peek();
	
	public void push(Object element);
	
	public boolean isEmpty();
	
	public int size();
	
	
}
