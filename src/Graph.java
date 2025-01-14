import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Graph {

	// map from names of cities to nodes
	private HashMap<String, GraphNode> cityMap;


	// Constructor
	public Graph() {
		//		HashMap<String, GraphNode> map = new HashMap<String, GraphNode>();
		this.cityMap = new HashMap<String, GraphNode>();
	}


	// methods to implement 


	// TO DO:
	// Prompt the user to pick two cities. 
	// Using Dijkstra's algorithm, 
	// determine the shortest path is between those two cities 
	// and report it to the user. The output must 
	// include the total distance and the distance of each link.



	public void findPath() 
	{

		//		distanceTable - a hashmap whose keys are city names and values are distances
		HashMap<String,Double> distanceTable = new HashMap <String,Double>();

		//		currentLocation - a city name, initialed to the value of start
		String currentLocation;



		//Start Location and End Location
		String startLoc;
		String endLoc;

		//		currentPath - a Path object, initialized to contain only the start and a distance of 0

		//		pathQueue - a priority queue of Path objects 
		ArrayList<Path> pathQueue = new ArrayList<Path>();

		//Scanner for start and end locations
		Scanner scan = new Scanner(System.in);

		//Get the data!
		System.out.println("Please enter the starting location: ");
		startLoc = scan.nextLine();


		//Initialize Starter Location to input
		currentLocation = startLoc;



		//initialize current path to contain only the start and a distance of 0
		Path currentPath = new Path(currentLocation);

		//Add starter location to distance map with distance 0
		//		distanceTable.put(startLoc, 0.0); // DO NOT NEED


		System.out.println("Please enter the end location: ");
		endLoc = scan.nextLine();


		//		Algorithm Steps
		//		While currentLocation is not equal to end:

		while(currentLocation.compareTo(endLoc)!=0)
		{
			//			If currentLocation is not already in distanceTable:
			if(!distanceTable.containsKey(currentLocation))
			{
				//				Add currentLocation to distanceTable, setting its distance value to the currentPath's length
				distanceTable.put(currentLocation,currentPath.getLength());

				//				Add all paths ending with currentLocation's adjacent cities into pathQueue, skipping any already in distanceTable.
				//For all of currentLocation's adjacent cities (from cityMap.getOutboundedges)

				HashMap<GraphNode,Double> cities = cityMap.get(currentLocation).getOutboundEdges();

				for(GraphNode loc: cities.keySet())
				{


					String adjCity = loc.getLocation();
					//If adjacentCities are not already in distanceTable
					if(!distanceTable.containsKey(adjCity)){
						//Make new Path, copy previous, and add the city to that Path.
						Path p1 = new Path(currentPath);

						p1.addNode(adjCity,p1.getLength() + cities.get(loc).doubleValue()); 
						//Collect all of currLocation's adjacent cities and their distances and put them into pathQueue
						pathQueue.add(p1);


					}

				}

			}




			//Index for the shortest path!
			int pathIndex=0;

			for(int i=0; i< pathQueue.size(); i++)
			{

				//If the length of pathIndex is bigger than length at i
				if(pathQueue.get(pathIndex).getLength() > pathQueue.get(i).getLength())
				{
					pathIndex=i;
				}		
			}
			//		Dequeue the shortest path from pathQueue, storing it in currentPath.
			currentPath = pathQueue.remove(pathIndex);

			//		Set currentLocation to the last city in currentPath.
			currentLocation = currentPath.getLastNode();


		}
		//		currentPath is now set to the best path! You can report it to the user.
		currentPath.printPath();
		System.out.println(" Total Distance: " + currentPath.getLength());
	}


	// List cities in alphabetical order
	// put the cities in order and return
	// use compareTo to order them
	public void listInOrder() {

		//the map is empty 
		if(cityMap.isEmpty()) {
			System.out.println("There is no city data!");
			return;
		}

		// Pull the key set and put into an array of Strings
		ArrayList<String> toSort = new ArrayList<String>(cityMap.keySet());
		//		sorted.toArray();
		String[] toSortAgain = toSort.toArray(new String[0]);
		Arrays.sort(toSortAgain);

		for(String s : toSortAgain) {
			System.out.println(s);
		}

		//System.out.println(Arrays.toString(toSortAgain));

		//		selectionSort(sorted);
	}


	//DONE!
	// Search for cities
	// cities must be listed in order 
	// use a scanner 
	public void search() {

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter city:");
		String input = myObj.nextLine();	



		// Pull the key set and put into an array of Strings
		ArrayList<String> toSort = new ArrayList<String>(cityMap.keySet());
		//		sorted.toArray();
		String[] toSortAgain = toSort.toArray(new String[0]);

		Arrays.sort(toSortAgain);

		for(String s : toSortAgain) {
			if(s.contains(input))
			{
				System.out.println(s);
			}
		}
	}

	//Works!
	// Prompt the user to select a city, 
	// then show the names and distances to any adjacent cities (one link away).
	// The cities must be listed in order by distance

	public void displayInfo() {

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter city:");
		String input = myObj.nextLine();

		// Base Case: The city is not in the map
		if(!cityMap.containsKey(input)) {
			System.out.println("There is no cities in list!");
			return;
		}
		else {
			cityMap.get(input).boundingEdges();
		}
	}




	// DONE!
	// Same thing as above
	public void add(String cityName) {
		// if it is not in the list then add

		// Check if it is already in the list
		if(!cityMap.containsKey(cityName)) {
			// add to list 

			cityMap.put(cityName, new GraphNode(cityName));
		}

		else {
			//System.out.println(" City is already in the list!");
		}
	}

	//Done!
	// Add/Update link
	// Prompt the user to pick two cities. 
	// If there is not already a link between those two cities, 
	// prompt them to input the distance between them, 
	// storing that information for future use. If there is already a link, 
	// prompt them to update the distance
	public void addEdge (String cityA, String cityB, double distance) {

		// Assume that both cities exist

		// System.out.println("Adding an edge between " + cityA + " and " + cityB + ": " + distance + " mi");
		// Check for a link


		// do both directions
		GraphNode a = cityMap.get(cityA); //where the key of city A is mapped to
		GraphNode b = cityMap.get(cityB); //where the key of city B is mapped to

		//using created data
		a.addEdge(b, distance);
		b.addEdge(a, distance);

		// System.out.println("Successfully added edge to graph!");

	}




}
