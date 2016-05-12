package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HeapBuilder <T extends Comparable<T>> implements IHeap<T>  {

	private List< HeapElements <T> > heapValues; 
	private HeapElements<T> heapNode;
	private int heapSize;
	
	@Override
	public INode<T> getRoot() {
		
		if(heapSize == 0) return null;
		return heapValues.get(0);
	}

	@Override
	public int size() {
		
		return this.heapSize;
	}

	@Override
	public void heapify(INode<T> node) {
		
		if(node == null) return;
		
		HeapElements<T> leftChild = (HeapBuilder<T>.HeapElements<T>) node.getLeftChild();
		
		if(leftChild != null){
			
			HeapElements<T> rightChild = (HeapBuilder<T>.HeapElements<T>) node.getRightChild();
			HeapElements<T> biggerNode = leftChild;
			
			if(rightChild != null){
			
				if(leftChild.getValue().compareTo(rightChild.getValue()) < 0) 
					biggerNode = rightChild;
			}
			
			if(node.getValue().compareTo(biggerNode.getValue()) < 0){
			
				T tempNode = node.getValue();
				node.setValue(biggerNode.getValue());
				//rootNode.elementindex = biggerNode.getelementindex();
				biggerNode.setValue(tempNode);
				//biggerNode.setelementindex(tempNode.getelementindex());
				heapify(biggerNode);
			}
		}
	}

	public List<HeapElements<T>> getHeapValues() {
		return heapValues;
	}

	public void setHeapValues(List<HeapElements<T>> heapValues) {
		this.heapValues = heapValues;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	@Override
	public T extract() {
		
		if(heapSize == 0) return null;
		
		HeapElements <T> heapRoot = (HeapBuilder<T>.HeapElements<T>) getRoot();
		T rootValue = heapRoot.getValue();
		HeapElements <T> newRoot = heapValues.get(heapSize - 1);
		heapRoot.setValue(newRoot.getValue());
		heapValues.remove(heapSize - 1);
		heapSize--;
		
		heapify(heapRoot);
		
		return rootValue;
	}

	@Override
	public void insert(T element) {
	
		if(heapSize == 0) heapValues = new ArrayList< HeapElements <T> >(); 
		heapNode = new HeapElements<T>();
		
		int inputIndex = heapSize;
		boolean swapElements = true;
		
		heapNode.setValue(element);
		heapNode.setelementindex(inputIndex);
		heapValues.add(heapNode);
		heapSize++;
		
		while(swapElements == true && inputIndex != 0){
			
			heapNode = heapValues.get(inputIndex);
			HeapElements <T> parent = (HeapBuilder<T>.HeapElements<T>) heapNode.getParent();
			
			if(heapNode.getValue().compareTo(parent.getValue()) > 0){
				
				T tempValue = heapNode.getValue();
				//tempNode.setelementindex(heapNode.getelementindex());
				heapNode.setValue(parent.getValue());
				//heapNode.elementindex = parent.getelementindex();
				parent.setValue(tempValue);
				//parent.setelementindex(tempNode.getelementindex());
				inputIndex = parent.elementindex;
				
			} else swapElements = false;
		}
	}

	@Override
	public void build(Collection<T> unordered) {
		
		if(unordered == null) return;
		
		heapSize = 0;
		heapValues = new ArrayList< HeapElements <T> >();

		Iterator < T > iterateListInput = unordered.iterator();
	    
	    
	    while(iterateListInput.hasNext()){
	    	
	    	insert(iterateListInput.next());
	    }
	}
	
	public class HeapElements <T extends Comparable<T>> implements INode<T> {

		private int elementindex;
		private T elementValue;
		
		@Override
		public INode<T> getLeftChild() {
			
			int leftChildIndex = elementindex * 2 + 1;
			if(leftChildIndex < heapSize) return (INode<T>) heapValues.get(leftChildIndex);
			return null;
		}

		@Override
		public INode<T> getRightChild() {
			
			int rightChildIndex = elementindex * 2 + 2;
			if(rightChildIndex < heapSize) return (INode<T>) heapValues.get(rightChildIndex);
			return null;
			
		}

		@Override
		public INode<T> getParent() {
			
			if(heapSize == 0) return null;
			
			int parentIndex = (elementindex - 1) / 2;
			
			return (INode<T>) heapValues.get(parentIndex); 
			
		}

		@Override
		public T getValue() {
			
			return elementValue;
		}

		@Override
		public void setValue(T value) {
			
			this.elementValue = value;
		}

		public int getelementindex() {
			return elementindex;
		}

		public void setelementindex(int elementindex) {
			this.elementindex = elementindex;
		}
	}
}
