package eg.edu.alexu.csd.oop.calculator.cs44;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTests {

	
	
	/*@Test
	public void test1() {
		
	
		Programme p = Programme.getInctance();
		p.input("2+3");
		String s = p.getResult();
		assertEquals("5.0", s);
		
		p.input("2++");
		
		try {
			String h = p.getResult();
			System.out.println("You shouldn't come here!");
		} catch ( Exception e ){
		
		}
		
		p.input("3-1");
		s = p.getResult();
		assertEquals("2.0", s);
		
		s = p.current();
		assertEquals("3-1", s);
		s = p.prev();
		assertEquals("2+3", s);
		s = p.current();
		assertEquals("2+3", s);
		
		s = p.next();
		assertEquals("3-1", s);
		
		s = p.current();
		assertEquals("3-1", s);
		
		s = p.prev();
		assertEquals("2+3", s);
		
		s = p.current();
		assertEquals("2+3", s);
		
		p.input("3/0");
		
		try{
			
			s = p.getResult();
			
		} catch ( Exception e  ){
			System.out.println("You should come here!");
		}
		
		s = p.prev();
		assertEquals(null, s);
		
		s = p.next();
		s = p.next();
		assertEquals(null, s);
		
	}*/
	
	/*@Test
	public void test2() {
		
		Programme p = Programme.getInctance();
		p.input("2+3");
		p.input("4+5");
		String s = p.current();
		assertEquals("4+5", s);
		
		s = p.next();
		assertEquals(null, s);
		s = p.next();
		assertEquals(null, s);
		
		s = p.prev();
		assertEquals("2+3", s);
		s = p.prev();
		assertEquals(null, s);
		s = p.next();
		assertEquals("4+5", s);
		s = p.current();
		assertEquals("4+5", s);
		
		try{
			
			p.load();
		} catch ( Exception e ){
			
			System.out.println("You should come here");
			
		}
		p.save();
		p.input("8+9");
		p.input("11+12");
		p.load();
		s = p.current();
		assertEquals("4+5", s);
		s = p.prev();
		assertEquals("2+3", s);
		s = p.prev();
		assertEquals(null , s);
		p.current();
		p.save();
		p.load();
		s = p.current();
		assertEquals("2+3", s);
		
		s= p.prev();
		assertEquals(null , s);
		s = p.next();
		assertEquals(null , s);
		
				
	}*/
	
	@Test
	public void test3() {
		
		Programme p = Programme.getInctance();
		p.input("1+2");
		p.input("2+3");
		p.input("3+4");
		p.input("4+5");
		String s = p.current();
		assertEquals("4+5", s);
		s = p.prev();
		assertEquals("3+4", s);
		s = p.prev();
		assertEquals("2+3", s);
		s = p.current();
		assertEquals("2+3", s);
		p.input("6+7");
		s = p.current();
		assertEquals("6+7", s);
		s = p.prev();
		assertEquals("2+3", s);
		s = p.next();
		assertEquals("6+7", s);
		s = p.next();
		assertEquals(null, s);
	}

}
