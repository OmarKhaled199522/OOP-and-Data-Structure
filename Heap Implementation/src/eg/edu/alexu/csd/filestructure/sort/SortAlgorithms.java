package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.filestructure.sort.HeapBuilder.HeapElements;


public class SortAlgorithms <T extends Comparable<T>> implements ISort<T> {

	private HeapBuilder <T> heapBuilder;
	private HeapBuilder<T>.HeapElements<T>  heapRoot;
	private HeapBuilder<T>.HeapElements<T> lastNode;
	private List<HeapBuilder<T>.HeapElements<T>> heapValues; 
	
	@Override
	public IHeap<T> heapSort(ArrayList<T> unordered) {
		
		heapBuilder = new HeapBuilder<T>();
		heapBuilder.build(unordered);	
		heapValues = heapBuilder.getHeapValues();
		
		int inputSize = unordered.size();
		int heapSize = heapBuilder.getHeapSize();
		
		for(int i = 0; i < inputSize - 1; i++){
			
			heapRoot = (HeapBuilder<T>.HeapElements<T>) heapBuilder.getRoot();
			lastNode = heapValues.get(heapSize - 1);
			
			T tempValue = heapRoot.getValue();
			//int tempIndex = heapRoot.getelementindex();
			
			heapRoot.setValue(lastNode.getValue());
			//heapRoot.setelementindex(lastNode.getelementindex());
			
			lastNode.setValue(tempValue);
			//lastNode.setelementindex(tempIndex);
			
			heapValues.set(0, heapRoot);
			heapValues.set(heapSize - 1, lastNode);
			heapSize--;
			
			heapBuilder.setHeapSize(heapSize);
			heapBuilder.setHeapValues(heapValues);
			
			heapBuilder.heapify(heapRoot);
		}
		
		heapBuilder.setHeapSize(inputSize);
		
		return heapBuilder;
	}

	@Override
	public void sortSlow(ArrayList<T> unordered) {
		
		
		for(int i = 0; i < unordered.size() - 1; i++){
			
			for(int j = 0; j < unordered.size() - 1; j++){
				
				
				if(unordered.get(j).compareTo(unordered.get(j + 1)) > 0 ){
				
					T tempValue = unordered.get(j);
					unordered.set(j, unordered.get(j + 1));
					unordered.set(j + 1, tempValue);
				}
			}
		}
	}

	@Override
	public void sortFast(ArrayList<T> unordered) {
		
		mergeSort(unordered , 0 , unordered.size() - 1);
	}
	
	public void mergeSort(ArrayList<T> unordered, int low, int high){
		
		
		int mid;
		
		if(low < high) {
			
			mid = (low+high)/2;
			
			mergeSort(unordered, low, mid);
			mergeSort(unordered, mid + 1, high);
			merge(unordered, low, mid, high);
		}
	}
	
	void merge(ArrayList<T> unordered, int l, int m, int r){
	
		 int i, j, k;
		 int n1 = m - l + 1;
		 int n2 =  r - m;
		
		ArrayList<T> arrL = new ArrayList<T>();
		ArrayList<T> arrR = new ArrayList<T>();
		
		  for (i = 0; i < n1; i++)
		      arrL.add(unordered.get(l + i));
		  
		  for (j = 0; j < n2; j++)
		      arrR.add( unordered.get(m + 1+ j) );
		    
		    i = 0; 
		    j = 0; 
		    k = l; 
		    
		    while (i < n1 && j < n2){
		    	
		        if (arrL.get(i).compareTo(arrR.get(j)) < 1){
		            unordered.set(k, arrL.get(i));
		            i++;
		            
		        } else {
		        	
		        	unordered.set(k, arrR.get(j));
		            j++;
		        }
		        
		        k++;
		    }
		 
		  
		    while (i < n1){
		    	unordered.set(k, arrL.get(i));
		        i++;
		        k++;
		    }
		 
		    while (j < n2){
		    	unordered.set(k, arrR.get(j));
		        j++;
		        k++;
		    }
	}
}
