
/**
 *  @author adileneherreraorozco
 *  @author jadaross
 *  
 *  Final Project
 *  Dec. 2nd 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Graph newGraph = new Graph();
		try {
			File file = new File("california-data.txt");
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] data = line.split(",");
				//				System.out.println("City A: " + data[0]);
				//				System.out.println("City B: " + data[1]);
				//				System.out.println("Distance: " + data[2]);
				newGraph.add(data[0]);
				newGraph.add(data[1]);
				double dis = Double.parseDouble(data[2]);
				newGraph.addEdge(data[0], data[1], dis);
				// System.out.println("Ran once.");
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.print("*** File could not be opened.");
			return;

		}

		String userResponse = "yes";
		//Prompt for the Methods - We do not have to keep the name; I just thought about it on da fly
		while (true) {
			System.out.println();
			System.out.println("Welcome to MapMe ! \n\n Please enter an option below: \n"
					+ " 1) List Cities in Order \n 2) Display Info of a City \n 3) Search Cities "
					+ "\n 4) FindPath \n 5) Add a City \n 6) Exit");
			Scanner input = new Scanner(System.in); // Create a Scanner object
			String optionSelect = input.nextLine();


			//List Cities in Order Option
			if(optionSelect.compareTo("1")==0) {
				newGraph.listInOrder();
			}

			//DisplayInfo Option -- Needs Work
			if(optionSelect.compareTo("2")==0) {
				newGraph.displayInfo();
			}
			
			//Search City Option
			if(optionSelect.compareTo("3")==0) {
				newGraph.search();
			} 

			//FindPath option
			if(optionSelect.compareTo("4")==0) {
				newGraph.findPath();
			}
			
			//Add City option
			if(optionSelect.compareTo("5")==0)
			{
				System.out.println("Please enter City name: ");
				String addCity = input.nextLine();
				newGraph.add(userResponse);
				System.out.println("Your city has been added!");
				
				System.out.println("Would you like to add an edge? (y/n)");
				userResponse = input.nextLine();
				
				//Adding an Edge
				if(userResponse.compareTo("y")==0)
				{
					System.out.println("Please enter an edge city: ");
					String edgeCity = input.nextLine();
					
					System.out.println("Please enter the distance: ");
					double in = input.nextDouble();
					
					newGraph.addEdge(addCity, edgeCity, in);
					
					System.out.println("Edge has been created");
				}
			
			}
			
			if(optionSelect.compareTo("6")==0)
			{
				return;
			}
		}
		
		//Test for Path class
//				ArrayList<String> foodPlaces = new ArrayList<String>();
//				foodPlaces.add("Taco Bell");
//				Path test = new Path(foodPlaces);
//				test.addNode("Burger King", 1);
//				test.addNode("McDonalds", 5);
//				
//				System.out.println("The last store added was "+ test.getLastNode());
//				System.out.println("The total length of the test path is " + test.getLength());

	}

}
