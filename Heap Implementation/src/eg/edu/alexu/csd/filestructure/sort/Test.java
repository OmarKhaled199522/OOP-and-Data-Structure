package eg.edu.alexu.csd.filestructure.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;

import eg.edu.alexu.csd.filestructure.sort.HeapBuilder.HeapElements;

public class Test {

	@org.junit.Test
	public void test1() {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(2); 
		arr.add(3);
		arr.add(1);
		
		HeapBuilder <Integer> e = new HeapBuilder <Integer>();
		
		
		SortAlgorithms<Integer> g = new SortAlgorithms <Integer>();
		
		g.sortFast(arr);
		
		System.out.println("************");
		for(int i = 0; i < 3; i++) System.out.println(arr.get(i));
		System.out.println("***************");
		
		//System.out.println(e.extract());
		
		//e.build(arr);
		
		e.insert(7);
		//System.out.println(e.extract());
		//System.out.println(e.getRoot());
		
		HeapBuilder <Integer>.HeapElements <Integer> node = (HeapBuilder<Integer>.HeapElements<Integer>) e.getRoot();
		
		//System.out.println(node.getValue());
		
		e.insert(2);
		e.insert(5);
		e.insert(3);
		
		for(int i = 0; i < 5; i++) 
			System.out.println(e.extract());
		
		System.out.println("----------------------------");
		
		e.insert(4);
		e.insert(6);
		e.insert(77);
		
		e.extract();
		e.extract();
		e.insert(1);
		
		for(int i = 0; i < 100; i++) e.insert(i);
		
		for(int i = 0; i < 100; i++)  e.extract();
		
		System.out.println(e.getRoot().getValue());
		
		e.extract();
		
		System.out.println(e.getRoot().getValue());
		System.out.println(e.getRoot());
		
		//for(int i = 0; i< 5; i++) System.out.println(e.extract());
		
		/*
		
		SortAlgorithms <Integer> sort = new SortAlgorithms <Integer>();
		
		HeapBuilder <Integer> h = (HeapBuilder<Integer>) sort.heapSort(arr);
		
		for(int i = 0; i < 3; i++) 
			System.out.println(h.extract());
		
		//sort.sortFast(arr);
		
		//int j = 0;
		
		//for(Integer i : arr) System.out.println(arr.get(j++));*/
	}

}
