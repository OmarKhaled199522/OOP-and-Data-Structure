package eg.edu.alexu.csd.ds.queue.cs44;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	MyQueue q = new Queue_linkedlist();
	MyQueue a = new Queue_array();
	
	@Test
	public void test1() {
		
		q.enqueue(5);
		q.enqueue(10);
		q.enqueue(12);
		assertEquals(5, q.dequeue());
		assertEquals(10, q.dequeue());
		assertEquals(12, q.dequeue());
	}
	
	@Test
	public void test2() {
		
		assertEquals(0, q.size());
		q.enqueue("omar khaled");
		int arr[] = {1 , 2 , 4 , 5 ,6};
		q.enqueue(arr);
		assertEquals(2, q.size());
		
	}
	
	@Test
	public void test3() {
		
		try{
			q.dequeue();
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		assertEquals(0, q.size());
	}
	
	@Test
	public void test4() {
		
		a.enqueue(3);
		a.enqueue(4);
		assertEquals(2, a.size());
		assertEquals(3, a.dequeue());
		assertEquals(1, a.size());
		a.dequeue();
		assertEquals(0, a.size());
	}
	
	@Test
	public void test5() {
		
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(6);
		a.enqueue(7);
		a.enqueue(8);
		a.enqueue(9);
		a.enqueue(10);
		assertEquals(10, a.size());
	}
	
	@Test
	public void test6() {
		
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(6);
		a.enqueue(7);
		a.enqueue(8);
		a.enqueue(9);
		a.enqueue(10);
		
		try{
			a.enqueue(11);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void test7() {
		
		try{
			a.dequeue();
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		assertEquals(true, a.isEmpty());
	}
	
	@Test
	public void test8() {
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(6);
		a.enqueue(7);
		a.enqueue(8);
		a.enqueue(9);
		a.enqueue(10);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		assertEquals(0, a.size());
		assertEquals(true, a.isEmpty());
	
	}
	
	@Test
	public void test9() {
		MyQueue m = new Queue_array(3);
		m.enqueue(1);
		assertEquals(false, m.isEmpty());
		m.enqueue(2);
		m.enqueue(3);
		try{
			m.enqueue(4);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		assertEquals(1, m.dequeue());
		m.enqueue(1);
		assertEquals(2, m.dequeue());
		assertEquals(3, m.dequeue());
		assertEquals(false, m.isEmpty());
		assertEquals(1, m.dequeue());
		
	}
	
	@Test
	public void test10() {
		assertEquals(0, a.size());
		a.enqueue(1);
		a.dequeue();
		assertEquals(0, a.size());
	}
	
}
