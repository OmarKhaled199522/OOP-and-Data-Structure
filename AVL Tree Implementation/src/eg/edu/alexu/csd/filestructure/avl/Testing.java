package eg.edu.alexu.csd.filestructure.avl;

import java.io.File;

import org.junit.Test;

public class Testing {

	@Test
	public void test1() {
		
		AVLTreeImplementation <Integer> AVL = new AVLTreeImplementation<Integer>();
		
		System.out.println(AVL.delete(111));
		AVL.insert(3);
		//System.out.println(AVL.delete(3));
		AVL.insert(4);
		AVL.insert(2);
		AVL.insert(5);
		System.out.println(AVL.getRootHeight());
		AVL.insert(7);
		System.out.println(AVL.getRootHeight());
		AVL.insert(10);
		System.out.println(AVL.getRootHeight());
		AVL.insert(12);
		System.out.println(AVL.getRootHeight());
		AVL.insert(13);
		System.out.println(AVL.getRootHeight());
		System.out.println(AVL.search(13));
		System.out.println(AVL.delete(13));
		System.out.println(AVL.search(13));
		System.out.println(AVL.getRootHeight());
	}
	
	@Test
	public void test2() {
		
		DictionaryImplementation avl = new DictionaryImplementation();
		
		File file = new File("read.txt");
		avl.load(file);
		System.out.println(avl.height());
		System.out.println(avl.size());
		System.out.println(avl.exists("4"));
		System.out.println(avl.exists("90"));
		
	}
	
	@Test
	public void test3() {
		
		AVLTreeImplementation <Integer> AVL = new AVLTreeImplementation<Integer>();
		
		AVL.insert(5);
		AVL.insert(7);
		AVL.insert(6);
	}

}
