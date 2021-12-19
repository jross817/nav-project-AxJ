import java.util.ArrayList;

public class Path {

	private ArrayList<String> pathNodes;
	private double distance;
	private int length;
	// Constructor 
	public Path(ArrayList<String> pathNodes) {
		this.pathNodes = pathNodes;
		distance = 0.0;
		length = 1;
	}
	
	// methods to implement 
	
	public void addNode(String node, double distance) {
		// add node to the end,
		// increase length by distance
		
		pathNodes.add(node);
		length+=distance;
	}
	
	
	public String getLastNode() {
		return pathNodes.get(pathNodes.size()); // placeholder
	}

}
