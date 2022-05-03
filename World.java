import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class World {
    ArrayList<Building> totalBuildings;

    public World(String graphName) {
        try {
            totalBuildings = new ArrayList<Building>();
            File input = new File(graphName);
            Scanner sc = new Scanner(input);
            String nextLine = sc.nextLine();
            String[] arrNextLine = nextLine.split(" ",2);
            while (sc.hasNextLine()) {
                if (arrNextLine[0].equals("thisBuilding")) {
                    String buildingName = arrNextLine[1];
                    ArrayList<Neighbor> toAddNeighbors = new ArrayList<Neighbor>();
                    while (true) {
                        if (! sc.hasNextLine()) break;
                        nextLine = sc.nextLine();
                        arrNextLine = nextLine.split(" ", 2);
                        if (! arrNextLine[0].equals("thisBuilding")) {
                            toAddNeighbors.add(new Neighbor(arrNextLine[0],Integer.parseInt(arrNextLine[1])));
                        } else break;
                    }
                    totalBuildings.add(new Building(buildingName, toAddNeighbors));
                }
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }

    }


}
