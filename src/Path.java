import java.util.ArrayList;

public class Path {

	private ArrayList<String> pathNodes;
	private double length;
	
	// Constructor 
	public Path(String newCity)
	{
		pathNodes = new ArrayList <String>();
		pathNodes.add(newCity);
		this.length = 0;
	}

	
	//Make a copy of another 
	public Path(Path otherPath)
	{
		pathNodes = new ArrayList<String>();
		
		for(String city: otherPath.pathNodes)
		{
			pathNodes.add(city);
		}
		
		length = otherPath.length;
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
	public Double getLength() {
		return length;
	}

}
