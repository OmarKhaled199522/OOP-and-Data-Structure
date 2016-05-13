package eg.edu.alexu.csd.ds.iceHockey.cs44;

import java.awt.Point;

public class CameraEngine implements Iplayfinder {

	public  int max_right = 0;
	public  int max_left = 0;
	public  int max_top = 0;
	public  int max_bottom = 0;
	public  int indicate1 = 1;
	public  int indicate2 = 1;
	public  int num = 1;
	public  int count = 0;
	 Point[] objectPoints = new Point [50];
	
	 int [] [] change (String [] photo , int team){
		
		int [] [] arr = new int [photo.length + 2] [photo[0].length() + 2];
		
		for(int i = 0; i < photo.length; i++){
			for(int j = 0; j < photo[0].length(); j++){
				if(photo [i].charAt(j) - '0' == team) arr[i + 1][j + 1] = team;
			}
		}
		return arr;
	}
	
	
	public void recursion(int [] [] arr , boolean check [] [], int team , int threshold , int i , int j){
		
				if(check[i][j] == false && arr[i][j] == team){
					check[i][j] = true;
					if(arr[i][j + 1] == team && check[i][j + 1] == false){
						num++;
						if((j + 1) * 2 > max_right) max_right = (j + 1) * 2;
						recursion(arr , check , team , threshold ,i ,j + 1);
						
					} 
					
					if(arr[i + 1][j] == team && check[i + 1][j] == false){
						
						num++;
						//System.out.println(  (i + 1) * 2 + " " + max_bottom );
						if((i + 1) * 2 > max_bottom) max_bottom = (i + 1) * 2;
						//System.out.println(max_bottom);
						recursion(arr , check , team , threshold ,i + 1 , j);
						
					} 
					
					if(arr[i - 1][j] == team && check[i - 1][j] == false){
						
						num++;
						if(i - 1 < indicate1) max_top  = (i - 1) * 2 - 2;
						recursion(arr , check , team , threshold , i - 1, j);
						
					}
					
					if(arr[i][j - 1] == team && check [i][j - 1] == false){
						
						num++;
						//System.out.println( (j - 1) + " " + indicate2 );
						if(j - 1 < indicate2) max_left =  (j - 1) * 2 - 2;
						//System.out.println(max_left);
						recursion(arr , check , team , threshold , i , j - 1);
					}								
				} 
				
				if(i == indicate1 && j == indicate2){
					
					if(indicate2 == arr[0].length - 2){
						indicate1 = i + 1; indicate2 = 1;
						
					} else {indicate2++;}
					
					if(num * 4 >= threshold && arr[i][j] == team && check[i][j - 1] == false && check[i - 1][j] == false){
						
					
						int x_index = ( max_right) + (max_left);
						int y_index = ( max_bottom) + (max_top);
						//System.out.println(max_left + " " + max_right + " " + max_top + " " + max_bottom);
						//System.out.println(x_index / 2 +" " + y_index / 2);
						objectPoints[count] = new Point( x_index / 2,  y_index / 2);
						/*objectPoints[count].x= x_index / 2;
						objectPoints[count].y= y_index / 2;*/
						
						count++;
					}
				
					num = 1;
					max_right = 0;
					max_left = 0;
					max_top = 0;
					max_bottom = 0;
					
				}
				}
	
	@Override
	 public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
		
		
		int [] [] arr = change (photo , team);
		boolean [] [] check = new boolean [photo.length + 2] [photo[0].length() + 2];
		for(int i = 1; i < arr.length - 1; i++){
			for(int j = 1; j < arr[0].length; j++){
				
				 max_left = (j - 1) * 2;
				max_right = (j * 2);
				max_bottom = (i * 2);
				max_top = (i - 1) * 2; 
				recursion (arr, check, team , threshold , i , j);
				
			}
		}
		
		for(int i = 0; i < count - 1; i++){
			for(int j = i + 1; j < count; j++){
				
				if( (objectPoints[j].x < objectPoints[i].x ) || 
						( (objectPoints[j].x == objectPoints[i].x ) && (objectPoints[j].y < objectPoints[i].y) )){
					
					int temp1 = objectPoints[j].x;
					int temp2 = objectPoints[j].y;
					objectPoints[j].x = objectPoints[i].x;
					objectPoints[j].y = objectPoints[i].y;
					objectPoints[i].x = temp1;
					objectPoints[i].y = temp2;
				}
				
			}
		}
		
		
		return objectPoints;
	}
}
