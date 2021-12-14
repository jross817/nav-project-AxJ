import java.util.ArrayList;

public class Path {

	private ArrayList<GraphNode> pathNodes;

	// Constructor 
	public Path(ArrayList<GraphNode> pathNodes) {
		this.pathNodes = pathNodes;
		
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
