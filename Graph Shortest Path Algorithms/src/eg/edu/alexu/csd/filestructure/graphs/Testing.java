package eg.edu.alexu.csd.filestructure.graphs;

import java.io.File;

import org.junit.Test;

public class Testing {

	@Test
	public void test1() {
		
		IGraph graph = new IGraphImplementation();
		
		File file = new File("test.txt");
		graph.readGraph(file);
		
		int distances [] = new int [3];
		//graph.runDijkstra(0, distances);
		System.out.println(graph.runBellmanFord(0, distances));
		
		for(int i = 0; i < 3; i++){
			
			System.out.println(distances[i]);
		}
		
		System.out.println("----------------------------");
		//System.out.println(graph.getDijkstraProcessedOrder());
		//System.out.println(graph.getNeighbors(0));
	}

}
