import java.util.HashMap;

public class GraphNode {

	private String location;
	
	private HashMap<GraphNode, Double> outboundEdges;
	
	// Alternative to HashMap
	//	private ArrayList<GraphNode> neighbors;
	//	private ArrayList<Integer> distances;

	// Constructor 
	public  GraphNode(String loc) {
		this.location = loc;
		this.outboundEdges = new HashMap<GraphNode, Double>(); 
	}
	
	public void addEdge(GraphNode otherNode, double distance) {
		outboundEdges.put(otherNode, distance);
	}
}
