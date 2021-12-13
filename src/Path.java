import java.util.ArrayList;

public class Path {

	private ArrayList<GraphNode> pathNodes;
	
	private int length;
	
	// remember every class needs a constructor
	
	// Constructor 
	public void Path(ArrayList<GraphNode> pathNodes, int length) {
		this.pathNodes = pathNodes;
		this.length = length;
	}
	
	// methods to implement 
	
	public void addNode(GraphNode node, int distance) {
		// add node to the end,
		// increase length by distance
	}
	
	
	public GraphNode getLastNode() {
		return null; // placeholder
	}

}
