import java.util.ArrayList;

public class Path {

	private ArrayList<String> pathNodes;
	private double length;
	
	// Constructor 
	public Path(String newCity)
	{
		pathNodes.add(newCity);
		this.length = 0;
	}

	
	//Make a copy of another 
	public Path(Path otherPath)
	{
		Path p1 = new Path(otherPath);
	}
	
	// methods to implement 
	
	public void addNode(String node, double distance) {
		// add node to the end,
		// increase length by distance
		
		pathNodes.add(node);
		length+=distance;
	}
	
	
	public String getLastNode() {
		return pathNodes.get(pathNodes.size()-1); // placeholder
	}
	public Integer getSize() {
		return pathNodes.size();
	}
	
	

}
