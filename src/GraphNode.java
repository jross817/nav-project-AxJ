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
	
	public void boundingEdges() {
		// check its not empty
		if(!outboundEdges.isEmpty()) {
			for(GraphNode nextCity : outboundEdges.keySet()) {
				System.out.println(nextCity.location + ", " + outboundEdges.get(nextCity));
			}
		}else {
			System.out.println("City not in list!");
		}
	}
}
