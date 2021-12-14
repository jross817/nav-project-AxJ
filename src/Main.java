
/**
 *  @author adileneherreraorozco
 *  @author jadaross
 *  
 *  Final Project
 *  Dec. 2nd 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
		while (userResponse.compareTo("yes")== 0) {
			System.out.println();
			System.out.println("Welcome to MapMe ! \n\n Please enter an option below: \n"
					+ " 1) List Cities in Order \n 2) Display Info of a City \n 3) Search Cities "
					+ "\n 4) FindPath");
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
			
			System.out.println();
			System.out.println("Would you like to restart? (yes or no): ");
			userResponse = input.nextLine();
		}

	}

}
