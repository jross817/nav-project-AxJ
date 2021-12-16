import java.util.ArrayList;

public class Path {

	private ArrayList<GraphNode> pathNodes;
	private double distance;
	// Constructor 
	public Path(ArrayList<GraphNode> pathNodes) {
		this.pathNodes = pathNodes;
		distance = 0;
	}
	
	// methods to implement 
	
	public void addNode(GraphNode node, double distance) {
		// add node to the end,
		// increase length by distance
		
		pathNodes.add(node);
		node.addEdge(getLastNode(), distance);
	}
	
	
	public GraphNode getLastNode() {
		return pathNodes.get(pathNodes.size()); // placeholder
	}

}
