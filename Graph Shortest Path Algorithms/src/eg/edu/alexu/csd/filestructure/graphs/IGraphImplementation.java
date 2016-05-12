package eg.edu.alexu.csd.filestructure.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import eg.edu.alexu.csd.filestructure.graphs.IGraphImplementation.GraphNode;


class NodeSort implements Comparator<GraphNode> {
	 
	@Override
	public int compare(GraphNode o1, GraphNode o2) {
		
		 return o1.getNodeDistance() < o2.getNodeDistance() ? 
				-1 : o1.getNodeDistance() == o2.getNodeDistance() ? 0 : 1;
	}
	
}

public class IGraphImplementation implements IGraph {

	private int verticiesNumber;
	private int edgesNumber;
	private GraphConnection tempGraphConnection;
	private ArrayList<ArrayList<GraphConnection>> graphEdges;
	private ArrayList<Integer> graphVerticies;
	private ArrayList<Integer> vertexNeighbours;
	private ArrayList<Integer> processOrder;
	private PriorityQueue<GraphNode> verticesQueue;
	private boolean visitedNode [];
	
	private void initiateGraph(){
		
		graphEdges = new ArrayList<ArrayList<GraphConnection>>();
		
		for(int i = 0; i < verticiesNumber; i++){
			
			graphEdges.add(new ArrayList<GraphConnection>());
		}
	}
	
	@Override
	public void readGraph(File file) {
		
		try {
			
			BufferedReader br = new BufferedReader( new FileReader(file));
			String readLines = br.readLine();
			String [] graphInputs = readLines.split(" ");
			
			verticiesNumber = Integer.parseInt(graphInputs[0]);
			edgesNumber = Integer.parseInt(graphInputs[1]);
			initiateGraph();
			
			for(int i = 0; i < edgesNumber; i++){
				
				readLines = br.readLine();
				graphInputs = readLines.split(" ");
				int fromNode = Integer.parseInt(graphInputs[0]);
				int toNode = Integer.parseInt(graphInputs[1]);
				int edgeWeight = Integer.parseInt(graphInputs[2]);
				tempGraphConnection = new GraphConnection(fromNode, toNode, edgeWeight);
				graphEdges.get(fromNode).add(tempGraphConnection);
				
			}
			
			br.close();
			setVerticies();
			    
		} catch (Exception e) {
			
			throw new RuntimeException();
	    }
	}

	private void setVerticies(){
		
		graphVerticies = new ArrayList<Integer>();
		
		for(int i = 0; i < verticiesNumber; i++){ 
			graphVerticies.add(i);
		}
	}
	
	@Override
	public int size() {
		
		return edgesNumber;
	}

	@Override
	public ArrayList<Integer> getVertices() {
	
		return graphVerticies;
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		
		vertexNeighbours = new ArrayList<Integer>();
		ArrayList<GraphConnection> tempArray = graphEdges.get(v);
		int tempArraySize = tempArray.size();
		
		for(int i = 0; i < tempArraySize; i++){
		
			vertexNeighbours.add(tempArray.get(i).getToNode());
		}
		
		return vertexNeighbours;
	}

	@Override
	public void runDijkstra(int src, int[] distances) {
	
		processOrder = new ArrayList<Integer>();
		int numberOfVerticies = distances.length;
		visitedNode = new boolean [numberOfVerticies];
		
		for(int i = 0; i < numberOfVerticies; i++){
			distances[i] = Integer.MAX_VALUE / 2;
		}
		
		distances[src] = 0;
		GraphNode srcNode = new GraphNode(0 , src);
		NodeSort comparatorSort = new NodeSort();
		verticesQueue = new PriorityQueue<IGraphImplementation.GraphNode>
		(numberOfVerticies,comparatorSort);
		
		verticesQueue.add(srcNode);
		
		while(!verticesQueue.isEmpty()){
			
			
			GraphNode CurrentNode = verticesQueue.peek();
			verticesQueue.remove(verticesQueue.poll());
			
			if(visitedNode[CurrentNode.nodeIndex]){
				continue;
			}
			
			visitedNode[CurrentNode.nodeIndex] = true;
			processOrder.add(CurrentNode.nodeIndex);
			
			ArrayList<GraphConnection> tempArray = 
					graphEdges.get(CurrentNode.nodeIndex);
			
			int adjacentNodesNum = tempArray.size();
			
			for(int i = 0; i < adjacentNodesNum; i++){
				
				tempGraphConnection = tempArray.get(i);
				if(distances[CurrentNode.nodeIndex] +
				tempGraphConnection.getEdgeWeight() <
				distances[tempGraphConnection.getToNode()]){
					
					distances[tempGraphConnection.getToNode()] = 
					distances[CurrentNode.nodeIndex] +
					tempGraphConnection.getEdgeWeight();		
					
					verticesQueue.add(new GraphNode
					(distances[tempGraphConnection.getToNode()] ,
					tempGraphConnection.getToNode()));
				}
			}
		}
		
	}

	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		
		return processOrder;
	}

	@Override
	public boolean runBellmanFord(int src, int[] distances) {
		
		int numberOfVertices = distances.length;
		boolean graphCycle = true;
		
		for(int i = 0; i < numberOfVertices; i++){
			distances[i] = Integer.MAX_VALUE / 2;
		}
		
		distances[src] = 0;
		
		for(int k = 0; k < numberOfVertices - 1; k++){
		
			for(int i = 0; i < numberOfVertices; i++){
				
				int vertexNeighboursNum = graphEdges.get(i).size();
				ArrayList<GraphConnection> tempArray = graphEdges.get(i);
				
				for(int j = 0; j < vertexNeighboursNum; j++){
					
					tempGraphConnection = tempArray.get(j);
					int fromNode = tempGraphConnection.getFromNode();
					int toNode = tempGraphConnection.getToNode();
					int edgeWeight = tempGraphConnection.getEdgeWeight();
					
					if(distances[fromNode] + edgeWeight < distances[toNode]){
						
						distances[toNode] = distances[fromNode] + edgeWeight;
					}
				}
			}
		}
		
		for(int i = 0; i < numberOfVertices && graphCycle; i++){
			
			int vertexNeighboursNum = graphEdges.get(i).size();
			ArrayList<GraphConnection> tempArray = graphEdges.get(i);
			
			for(int j = 0; j < vertexNeighboursNum && graphCycle; j++){
				
				tempGraphConnection = tempArray.get(j);
				int fromNode = tempGraphConnection.getFromNode();
				int toNode = tempGraphConnection.getToNode();
				int edgeWeight = tempGraphConnection.getEdgeWeight();
				
				if(distances[fromNode] + edgeWeight < distances[toNode]){
					
					graphCycle = false;
				}
			}
		}
		
		return graphCycle;
	}

	public class GraphNode {
		
		private int nodeIndex;
		private int nodeDistance;
		
		public GraphNode(int nodeDistance, int nodeIndex){
			
			this.nodeIndex = nodeIndex;
			this.setNodeDistance(nodeDistance);
		}

		public int getNodeDistance() {
			return nodeDistance;
		}

		public void setNodeDistance(int nodeDistance) {
			this.nodeDistance = nodeDistance;
		}
	}

}
