package eg.edu.alexu.csd.ds.linkedList.cs44;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test1() {
		
		MyLinkedList l = new Single_Linkedlist();
		Object [] org = {2 , 3 , 4 , 5 , 6};
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		
		Object [] k = new Object [5];
		k [0] = l.get(0); k [1] = l.get(1); k [2] = l.get(2); k [3] = l.get(3);
		k [4] = l.get(4);
		
		assertEquals(org, k);
		Object [] org2 = {2 , 3 , 1000 , 4 , 5 , 6};
		l.add(2, 1000);
		assertEquals(1000, l.get(2));
		Object [] org3 = {2 , 3 , 1000 , 4 , -30 , 6};
		l.set(4, -30);
		assertEquals(-30, l.get(4));
		Single_Linkedlist l2 = (Single_Linkedlist) l.sublist(1, 4);
		assertEquals(4, l2.size());
		Object [] org4 = {3 , 1000 , 4 , -30};
		Object [] h = new Object [4];
		h [0] = l2.get(0); h [1] = l2.get(1); h [2] = l2.get(2); h [3] = l2.get(3);
		assertEquals(org4, h);
		l.remove(2);
		Object [] org5 = {2 , 3 , 4 , -30 , 6};
		Object [] e = new Object [5];
		e [0] = l.get(0); e [1] = l.get(1); e [2] = l.get(2); e [3] = l.get(3); e[4] = l.get(4);
		assertEquals(org5, e);
		assertEquals(5, l.size());
		assertEquals(true, l.contains(-30));
		assertEquals(false, l.contains(1));
		l.clear();
		assertEquals(true, l.isEmpty());
		
		
	}
	
	@Test
	public void test2() {
		
		MyLinkedList l = new Single_Linkedlist();
		//Object [] org = {10000 , 200 , -4000 , 1000000 , -700000000};
		l.add(10000);
		l.add(200);
		l.add(-4000);
		l.add(1000000);
		l.add(-700000000);
		assertEquals(true, l.contains(1000000));
		assertEquals(true, l.contains(-700000000));
		assertEquals(false, l.contains(-400));
		
	}
	
	@Test
	public void test3() {
		MyLinkedList l = new Single_Linkedlist();
		Object [] org = {100 , 20 , -67 , 3000 , -7007, -700000000};
		
		l.add(100);
		l.add(20);
		l.add(-67);
		l.add(3000);
		l.add(-7007);
		try{
			l.add(6, 5000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		l.add(5, -700000000);
		
		Object [] k = new Object [6];
		k [0] = l.get(0); k [1] = l.get(1); k [2] = l.get(2); k [3] = l.get(3);
		k [4] = l.get(4); k[5] = l.get(5);
		
		assertEquals(org, k);
	}
	
	@Test
	public void test4() {
		MyLinkedList l = new Single_Linkedlist();
		//Object [] org = {100 , 20 , -67 , 3000 , -7007, -700000000};
		
		
		try{
			l.add(1, 500);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
	
		try{
			l.get(1);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}	
	}
	
	@Test
	public void test5() {
		MyLinkedList l = new Single_Linkedlist();
		Object [] org = {-60000, -90000};
		
		try{
			l.add(1, 500);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		try{
			l.add(3, 50);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}

		l.add(0, -60000);
		l.add(1, -90000);
		try{
			l.add(4, 8000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		
		Object [] k = new Object [2];
		k [0] = l.get(0); k [1] = l.get(1);
		assertEquals(org, k);
	}
	
	@Test
	public void test6() {
		MyLinkedList l = new Single_Linkedlist();
		Object [] org = {6, 5};
		
		l.set(0, 7000);
		l.add(0, -60000);
		l.add(1, -90000);
		l.set(0, 6);
		l.set(1, 5);
		l.set(2, 10);
		
		Object [] k = new Object [2];
		k [0] = l.get(0); k [1] = l.get(1);
		assertEquals(org, k);
	}
	
	@Test
	public void test7() {
		MyLinkedList l = new Single_Linkedlist();
		
		l.add(0, -60000);
		l.add(1, -90000);
		assertEquals(false, l.isEmpty());
		l.clear();
		assertEquals(true, l.isEmpty());
	
	}
	
	@Test
	public void test8() {
		MyLinkedList l = new Single_Linkedlist();
		Object [] org = {100 , 20 , -7007};
		
		l.add(100);
		l.add(20);
		l.add(-67);
		l.add(3000);
		l.add(-7007);
		try{
			l.add(6, 5000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}

		l.add(5, -700000000);
		l.remove(2);
		l.remove(2);
		l.remove(3);
		try{
			l.remove(3);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		Object [] k = new Object [3];
		k [0] = l.get(0); k [1] = l.get(1); k [2] = l.get(2);
		
		assertEquals(org, k);
	}
	
	@Test
	public void test9() {
		MyLinkedList l = new Single_Linkedlist();
	
		Object [] org = {100 , 20 , -67 , 3000 , -7007, -700000000};
		
		try{
			l.remove(2);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		try{
			l.remove(0);;
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(100);
		l.add(20);
		l.add(-67);
		l.add(3000);
		l.add(-7007);
		try{
			l.add(6, 5000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}

		l.add(5, -700000000);
		
		Object [] k = new Object [6];
		k [0] = l.get(0); k [1] = l.get(1); k [2] = l.get(2); k [3] = l.get(3);
		k [4] = l.get(4); k[5] = l.get(5);
		
		assertEquals(org, k);
	}
	
	@Test
	public void test10() {
		MyLinkedList l = new Single_Linkedlist();
	
		Object [] org = {3 , 4 , 8 , 3000};
		
		try{
			l.remove(0);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(3);
		l.add(4);
		l.add(2 , -67);
		l.add(3 , 4000);
		l.remove(3);
		l.add(3, 3000);
	
		assertEquals(4, l.size());
	}
	
	@Test
	public void test11() {
		MyLinkedList l = new Single_Linkedlist();
		MyLinkedList l2 = new Single_Linkedlist();
	
		Object [] org = {3 , 4 , 8, 2000 , 30 , 3000, -500};
		
		
		l.add(3);
		l.add(4);
		l.add(2 , 8);
		l.add(3 , 2000);
		l.add(30);
		l.add(4000);
		l.remove(5);
		l.add(3000);
		l.add(6, -500);
		
		Object [] org2 = {8 , 2000 , 30 , 3000, -500};
		l2 = (Single_Linkedlist) l.sublist(2, 6);
		Object [] k = new Object [5];
		k [0] = l2.get(0); k [1] = l2.get(1); k [2] = l2.get(2); k [3] = l2.get(3);
		k [4] = l2.get(4); 
	
		assertEquals(org2, k);
	}
	
	@Test
	public void test12() {
		
		MyLinkedList l = new Double_Linkedlist();
		//Object [] org = {10000 , 200 , -4 , 1000000 , -7000};
		l.add(10000);
		l.add(200);
		l.add(-4);
		l.add(1000000);
		l.add(-7000);
		assertEquals(true, l.contains(1000000));
		assertEquals(true, l.contains(-7000));
		assertEquals(false, l.contains(-40));
		
	}
	
	@Test
	public void test13() {
		MyLinkedList l = new Double_Linkedlist();
		Object [] org = {100 , 20 , -67 , 3000 , -7007, -700000000};
		
		l.add(100);
		l.add(20);
		l.add(-67);
		l.add(3000);
		l.add(-7007);
		
		try{
			l.add(6, 5000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
	
		l.add(5, -700000000);
		
		Object [] k = new Object [6];
		k [0] = l.get(0); k [1] = l.get(1); k [2] = l.get(2); k [3] = l.get(3);
		k [4] = l.get(4); k[5] = l.get(5);
		
		assertEquals(org, k);
	}
	
	@Test
	public void test14() {
		MyLinkedList l = new Double_Linkedlist();
		
		try{
			l.add(1, 500);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}

		try{
			l.get(0);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void test15() {
		MyLinkedList l = new Double_Linkedlist();
		Object [] org = {80 , -60000 , -90000};
		
		try{
			l.add(1, 500);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(0, -60000);
		l.add(1, -90000);
		try{
			l.add(4, 8000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		try{
			l.add(-3, 3);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(0, 80);
		
		Object [] k = new Object [3];
		k [0] = l.get(0); k [1] = l.get(1); k[2] = l.get(2);
		assertEquals(org, k);
	}
	
	@Test
	public void test16() {
		MyLinkedList l = new Double_Linkedlist();
		Object [] org = {6, 5, 20};
		
		try{
			l.set(0, 7000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(0, -60000);
		l.add(1, -90000);
		l.set(0, 6);
		l.set(1, 5);
		try{
			l.set(2, 10);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(2, 60);
		l.set(2, 20);
		
		Object [] k = new Object [3];
		k [0] = l.get(0);
		k [1] = l.get(1);
		k[2] = l.get(2);
		assertEquals(org, k);
		
	}
	
	@Test
	public void test17() {
		MyLinkedList l = new Double_Linkedlist();
		
		l.add(0, -60000);
		l.add(1, -90000);
		assertEquals(false, l.isEmpty());
		l.clear();
		assertEquals(true, l.isEmpty());
	
	}
	
	@Test
	public void test18() {
		
		MyLinkedList l = new Double_Linkedlist();
		Object [] org = {20 , -7007};
		
		try{
			l.add(1, 100);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(20);
		l.add(-67);
		l.add(3000);
		l.add(-7007);
		try{
			l.add(5, -700000000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.remove(1);
		l.remove(1);
		try{
			l.remove(2);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		try{
			l.remove(3);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		Object [] k = new Object [2];
		k [0] = l.get(0); k [1] = l.get(1);
		
		assertEquals(org, k);
	}
	
	@Test
	public void test19() {
		MyLinkedList l = new Double_Linkedlist();
	
		Object [] org = {20 , -67 , 3000 , -7007, -700000000};
		
		try{
			l.remove(2);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		try{
			l.remove(0);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(100);
		l.add(20);
		l.add(-67);
		l.add(3000);
		l.add(-7007);
		try{
			l.add(6, 5000);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		l.add(5, -700000000);
		l.remove(0);
		
		Object [] k = new Object [5];
		k [0] = l.get(0); k [1] = l.get(1); k [2] = l.get(2); k [3] = l.get(3);
		k [4] = l.get(4);
		
		assertEquals(org, k);
	}
	
	@Test
	public void test20() {
		MyLinkedList l = new Double_Linkedlist();
	
		Object [] org = {3 , 4 , 8 , 3000};
		
		try{
			l.remove(0);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(3);
		try{
			l.remove(1);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
	
		l.add(4);
		try{
			l.remove(2);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(2 , -67);
		l.add(3 , 4000);
		l.remove(3);
		l.add(3, 3000);
	
		assertEquals(4, l.size());
	}
	
	@Test
	public void test21() {
		MyLinkedList l = new Double_Linkedlist();
		MyLinkedList l2 = new Double_Linkedlist();
	
		Object [] org = {3 , 4 , 8, 2000 , 30 , 3000, -500};
		
		try{
			l.remove(0);
			fail("you shouldn't come here");
		}catch(Exception e){
			
		}
		
		l.add(3);
		l.add(4);
		l.add(2 , 8);
		l.add(3 , 2000);
		l.add(30);
		l.add(4000);
		l.remove(5);
		l.add(3000);
		l.add(6, -500);
		
		Object [] org2 = {3 , 4 , 8 , 2000, 30};
		l2 = (Double_Linkedlist) l.sublist(0, 4);
		Object [] k = new Object [5];
		k [0] = l2.get(0); k [1] = l2.get(1); k [2] = l2.get(2); k [3] = l2.get(3);
		k [4] = l2.get(4); 
	
		assertEquals(org2, k);
	}

}
