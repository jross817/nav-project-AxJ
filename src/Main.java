
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
				System.out.println("Ran once.");
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.print("*** File could not be opened.");
			return;
			
		}
	}

}
