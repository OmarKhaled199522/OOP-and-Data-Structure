package eg.edu.alexu.csd.filestructure.graphs;

public class GraphConnection {
	
	private int fromNode;
	private int toNode;
	private int edgeWeight;
	
	public GraphConnection(int fromNode, int toNode, int edgeWeight){
		
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.edgeWeight = edgeWeight;
	}

	public int getFromNode() {
		return fromNode;
	}

	public void setFromNode(int fromNode) {
		this.fromNode = fromNode;
	}

	public int getToNode() {
		return toNode;
	}

	public void setToNode(int toNode) {
		this.toNode = toNode;
	}

	public int getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(int edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

}
