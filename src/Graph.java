import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

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
		//Use my own data structure - Probing, Priority Queue
		//Path class that we have to build ourselves
		Scanner input = new Scanner(System.in);
		// Prompt the user to pick two cities.
		System.out.println("Please enter the city you are starting in: ");

		String startCity = input.nextLine();
		System.out.println("Please enter the city you are ending in: ");
		String endCity = input.nextLine();
		
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

	//SOS !
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
