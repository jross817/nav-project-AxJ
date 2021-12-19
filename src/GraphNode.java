import java.util.HashMap;
import java.util.TreeMap;

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
	
	public void addEdge(String cityName, double distance) {
		outboundEdges.put(new GraphNode(cityName), distance);
	}
	
	public void boundingEdges() {
		// check its not empty
		if(!outboundEdges.isEmpty()) {
			System.out.println("Adjacent cities to " + this.location + " are: ");
			
			// Use a tree map to sort 
			// TreeMap already has a sort, so we have manipulated for it to sort 
			// them by distance, closest to farthest
			TreeMap<Double, GraphNode> map = new TreeMap<Double, GraphNode>();
			for(GraphNode city : outboundEdges.keySet()) {
			map.put(outboundEdges.get(city), city);
			}
			
			// Now we print our sorted map
			for(GraphNode location : map.values()) {
				System.out.println(location.location + ", " + outboundEdges.get(location) + " miles away");
			
				// This was our work before we sorted
//			for(GraphNode nextCity : outboundEdges.keySet()) {
//				System.out.println(nextCity.location + ", " + outboundEdges.get(nextCity) + " miles away");
			}
		}else {
			System.out.println("City not in list!");
		}
	}
}
