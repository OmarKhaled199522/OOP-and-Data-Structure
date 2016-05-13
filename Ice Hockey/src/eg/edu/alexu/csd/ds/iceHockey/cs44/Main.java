package eg.edu.alexu.csd.ds.iceHockey.cs44;

public class Main {

	public static void main(String[] args) {
		

		CameraEngine e = new CameraEngine();
		int team  = 3, threshold = 9;
		//String [] photo = {"8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8E0", "LUQ888A8TH90IH8",
				//"888QJ88R8SG88TY","88ZQV88B880UZ80", "FQ88WF8Q8GG88B8",  "8S888HGSB8FT8S8", "8MX88D88888T8K8",
				//"8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8", "8PK8H8T8888TQR8"};
		//String [] photo = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111"};
		String [] photo = {"33UUU", "U3UUU", "UUU3U", "UUU3U", "3333U"};
		e.findPlayers( photo,  team,  threshold);
		for(int i=0; e.objectPoints[i] != null;i++){
			System.out.println(e.objectPoints[i]);
		}
	}
	
	
}
