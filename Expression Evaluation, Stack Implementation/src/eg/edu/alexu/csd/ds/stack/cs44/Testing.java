package eg.edu.alexu.csd.ds.stack.cs44;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test1() {
		
		MyStack l = new Single_LinkedList();
		
		l.add(0, 'c');
		l.add(1, "de");
		assertEquals(2, l.size());
	}
	
	@Test
	public void test2() {
		
		MyStack l = new Single_LinkedList();
		
		try{
			l.add(1, 50);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		l.add(0, 3000);
		assertEquals(1, l.size());
	}
	
	@Test
	public void test3(){
		
		MyStack l = new Single_LinkedList();
		l.add(0, 3000);
		l.add(1, -90);
		l.add(2, 80);
		assertEquals(3000, l.pop());
		assertEquals(2, l.size());
	}
	
	@Test
	public void test4(){
		
		MyStack l = new Single_LinkedList();
		
		try{
			l.pop();
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void test5(){
		
		MyStack l = new Single_LinkedList();
		
		l.add(0, "test");
		l.add(1, 'c');
		l.add(2, 300);
		assertEquals("test", l.peek());
		
	}
	
	@Test
	public void test6(){
		
		MyStack l = new Single_LinkedList();
		try{
			l.peek();
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}	
	}
	
	@Test
	public void test7(){
		
		MyStack l = new Single_LinkedList();
		l.push(2);
		l.push("second");
		l.push("first");
		assertEquals("first", l.pop());
		
	}
	
	@Test
	public void test8(){
		
		MyStack l = new Single_LinkedList();
		l.push(60);
		l.push('c');
		l.push("size is three");
		assertEquals(3, l.size());
	}
	
	@Test
	public void test9(){
		
		MyStack l = new Single_LinkedList();
		l.push(4);
		assertEquals(4, l.peek());
		assertEquals(4, l.pop());
		try{
			l.pop();
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		assertEquals(0, l.size());
		l.push(2);
		l.push(1);
		assertEquals(1, l.peek());
		assertEquals(2, l.size());
	}
	
	@Test
	public void test10(){
		
		MyStack l = new Single_LinkedList();
		assertEquals(true, l.isEmpty());
		l.push(3);
		assertEquals(false, l.isEmpty());
	}
	
	@Test
	public void test11(){
		
		MyStack l = new Single_LinkedList();
		l.push(5);
		l.add(1, 9);
		l.push(8);
		l.pop();
		l.pop();
		l.push(4);
		l.pop();
		l.pop();
		assertEquals(true, l.isEmpty());

	}
	
	@Test
	public void test12(){
		
		MyStack l = new Single_LinkedList();
		assertEquals(0, l.size());
		l.push(1);
		l.push(2);
		l.pop();
		l.pop();
		l.push(1);
		assertEquals(1, l.size());
	}
	
	@Test
	public void test13(){
		
		MyStack l = new Single_LinkedList();
		l.add(0, 2);
		l.add(1, 5);
		l.add(2, 90);
		l.add(3, 30);
		assertEquals(2, l.peek());
		assertEquals(2, l.peek());
		assertEquals(4, l.size());
		assertEquals(2, l.pop());
		assertEquals(3, l.size());
		l.push(1111);
		assertEquals(false, l.isEmpty());
		int [] arr  = {1,2,3,4,5}; // this is one element
		l.push(arr);
		assertEquals(arr, l.peek());
		assertEquals(5, l.size());
		
	}
	@Test
	public void test14(){
		
		MyStack l = new Single_LinkedList();
		MyStack compare = new Single_LinkedList();
		
		compare.push(3);
		compare.push(4);
		String [] [] arr = {{"two", "dimension"}, {"2", "2"}};
		compare.push(arr);
		
		l.push(4);
		l.push(compare);
		assertEquals(compare, l.peek());
		assertEquals(2, l.size());
		
	}
	
	
	
	
	
	
	
	
}
