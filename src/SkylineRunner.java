import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SkylineRunner {

	public static void main(String [] args) {
		
		ArrayList<Building> buildingsFromFile = new ArrayList<Building>();
		
		File file = new File("sky1.dat");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			int left, height, right;
			
			String line;
			while ((line = reader.readLine()) != null) {
				left = Integer.parseInt(line.substring(0, 2).trim());
				height = Integer.parseInt(line.substring(3, 5).trim());
				right = Integer.parseInt(line.substring(6).trim());
				
				
				buildingsFromFile.add(new Building(left, height, right));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File wasn't found. Check your spelling.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("SOmething went wrong getting the files.");
			e.printStackTrace();
		}
		
		Building[] buildings = new Building[buildingsFromFile.size()];
		buildingsFromFile.toArray(buildings);
		
		Skyline sl = new Skyline(buildings);
		sl.createSkylineInduction();
		
		System.out.println(sl);
		System.out.println();
		
		sl.printSkyline();
		
		
	}
	
}
