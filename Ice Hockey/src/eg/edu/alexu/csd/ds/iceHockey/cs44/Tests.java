package eg.edu.alexu.csd.ds.iceHockey.cs44;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class Tests {

	
	@Test
	public void test1() {
	
		Point[] objectPoints1;
		Point [] compare1 = new Point [] { new Point (1, 17) , new Point(3, 3), new Point(3 , 10) , new Point (3, 25)
		, new Point (5, 21), new Point (8, 17), new Point (9, 2), new Point (10, 9), new Point (12, 23)
		, new Point (17, 16), new Point (18, 3), new Point (18, 11), new Point (18, 28), new Point (22, 20)
		, new Point (23, 26), new Point (24, 15), new Point (27, 2), new Point (28, 26), new Point (29, 16)};
		CameraEngine n = new CameraEngine();
		String [] arr = {"8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8E0", "LUQ888A8TH90IH8",
				"888QJ88R8SG88TY","88ZQV88B880UZ80", "FQ88WF8Q8GG88B8",  "8S888HGSB8FT8S8", "8MX88D88888T8K8",
				"8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8", "8PK8H8T8888TQR8"};
		objectPoints1 = n.findPlayers(arr , 8, 9);
		for(int i = 0; i < 18; i++){
			Assert.assertEquals(objectPoints1[i] , compare1[i]);
		}	
	
	}
	
	@Test
	public void test2() {
	
		Point[] objectPoints;
		Point [] compare = new Point [] { new Point (5, 5) , new Point(5 , 5)};
		CameraEngine q = new CameraEngine();
		String [] arr = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
		objectPoints = q.findPlayers(arr , 1, 3);
		for(int i = 0; i < 2; i++)
			Assert.assertEquals(objectPoints[i] , compare[i]);
	
	}
	
	@Test
	public void test3() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point (2, 2) , new Point(4 , 7)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"33UUU", "U3UUU", "UUU3U", "UUU3U", "3333U"};
		objectPoints2 = m.findPlayers(arr2 , 3, 9);
		for(int i = 0; i < 2; i++)
			Assert.assertEquals(objectPoints2[i] , compare2[i]);
		
	
	}
	
	@Test
	public void test4() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point (4, 4)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"3333", "3333", "3333", "3333"};
		objectPoints2 = m.findPlayers(arr2 , 3, 9);
		
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	
	}
	
	@Test
	public void test5() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point (1, 3)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"3113", "3131", "3223", "1311"};
		objectPoints2 = m.findPlayers(arr2 , 3, 9);
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	
	}
	
	@Test
	public void test6() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(2, 2)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"11","11"};
		objectPoints2 = m.findPlayers(arr2 , 1, 4);
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	}
	
	@Test
	public void test7() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(4, 4)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"4Q44A", "S4T48", "4MN4B", "4444V", "UUUU4"};
		objectPoints2 = m.findPlayers(arr2 , 4, 6);
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	}
	
	@Test
	public void test8() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(1, 1), new Point(1, 9), new Point(5, 5), new Point(9, 1), new Point(9, 9)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"3EEE3", "TF125", "12345", "00000", "30003"};
		objectPoints2 = m.findPlayers(arr2 , 3, 2);
		for(int i = 0; i < 5; i++)
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	}
	
	@Test
	public void test9() {
	
		Point[] objectPoints2;
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"3EEE3", "TF125", "12345", "00000", "30003"};
		objectPoints2 = m.findPlayers(arr2 , 6, 2);
		for(int i = 0; i < 5; i++)
			Assert.assertEquals(objectPoints2[i] , null);
		
	}
	
	@Test
	public void test10() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(4, 5), new Point (13, 9), new Point(14, 2)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"33JUBU33","3U3O4433","O33P44NB","PO3NSDP3","VNDSD333","OINFD33X"};
		objectPoints2 = m.findPlayers(arr2 , 3, 16);
		for(int i = 0; i < 3; i++)
			Assert.assertEquals(objectPoints2[i] , compare2[i]);
		
	}
	
	@Test
	public void test11() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(3, 8), new Point (4, 16), new Point(5, 4), new Point(16, 3),new Point(16, 17) , new Point(17, 9)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"44444H44S4","K444K4L444","4LJ44T44XH","444O4VIF44","44C4D4U444","4V4Y4KB4M4",
						  "G4W4HP4O4W","4444ZDQ4S4","4BR4Y4A444","4G4V4T4444"};
		objectPoints2 = m.findPlayers(arr2 , 4, 16);
		for(int i = 0; i < 5; i++)
			Assert.assertEquals(objectPoints2[i] , compare2[i]);
		
	}
	
	@Test
	public void test12() {
	
		Point[] objectPoints2;
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"1111", "1111", "1111", "1111"};
		objectPoints2 = m.findPlayers(arr2 , 1, 65);
		for(int i = 0; i < 5; i++)
			Assert.assertEquals(objectPoints2[i] , null);
		
	}
	
	@Test
	public void test13() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(4, 4)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"EEE1", "1DD1", "1A11", "111Z"};
		objectPoints2 = m.findPlayers(arr2 , 1, 36);
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	}
	
	@Test
	public void test14() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(4, 4)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"1EE1", "F11F", "C11C", "1MM1"};
		objectPoints2 = m.findPlayers(arr2 , 1, 5);
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	}
	
	@Test
	public void test15() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(5, 7), new Point(11, 3)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"WWWWW7", "W77EE7", "UU7II7", "HH77HH", "KKK7KK", "77777B"};
		objectPoints2 = m.findPlayers(arr2 , 7, 9);
		for(int i = 0; i < 2; i++)
			Assert.assertEquals(objectPoints2[i] , compare2[i]);
		
	}
	
	@Test
	public void test16() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(5, 6), new Point(5, 8)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"WWWWW", "22222", "2QQQ2", "2S2S2", "21212"};
		objectPoints2 = m.findPlayers(arr2 , 2, 4);
		for(int i = 0; i < 2; i++)
			Assert.assertEquals(objectPoints2[i] , compare2[i]);
		
	}
	
	@Test
	public void test17() {
	
		Point[] objectPoints2;
		Point [] compare2 = new Point [] { new Point(1, 1)};
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"1"};
		objectPoints2 = m.findPlayers(arr2 , 1, 1);
			Assert.assertEquals(objectPoints2[0] , compare2[0]);
		
	}
	
	@Test
	public void test18() {
	
		Point[] objectPoints2;
		CameraEngine m = new CameraEngine();
		String [] arr2 = {"   ", "    ", "     "};
		objectPoints2 = m.findPlayers(arr2 , 1, 1);
			Assert.assertEquals(objectPoints2[0] , null);
		
	}
	
	
}
