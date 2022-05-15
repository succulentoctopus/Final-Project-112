import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/*class that creates a "map" of the campus based on the .txt file that is passed into it.
the .txt file has a list of each building, its neighbors, and the distance between each.
this class creates a theoretical network from that information. The "world" created in this class is the basis
for being able to represent Building objects and finding distances between them.
 */

public class World {
    ArrayList<Building> totalBuildings;

    public World(String graphName) {
        try {
            totalBuildings = new ArrayList<Building>();
            File input = new File(graphName);
            Scanner sc = new Scanner(input);
            String nextLine = sc.nextLine();
            String[] arrNextLine = nextLine.split(" ");
            while (sc.hasNextLine()) {
                if (arrNextLine[0].equals("thisBuilding")) {
                    String buildingName = "";
                    for (int i = 1; i < arrNextLine.length; i++) {
                        buildingName += arrNextLine[i] + " ";
                    }
                    buildingName = buildingName.trim();
                    ArrayList<Neighbor> toAddNeighbors = new ArrayList<Neighbor>();
                    while (true) {
                        if (!sc.hasNextLine()) break;
                        nextLine = sc.nextLine();
                        arrNextLine = nextLine.split(" ");
                        if (!arrNextLine[0].equals("thisBuilding")) {
                            String neighborName = "";
                            for (int i = 0; i < arrNextLine.length - 1; i++) {
                                neighborName += arrNextLine[i] + " ";
                            }
                            neighborName = neighborName.trim();
                            toAddNeighbors.add(new Neighbor(neighborName, Integer.parseInt(arrNextLine[arrNextLine.length - 1])));
                        } else break;
                    }
                    totalBuildings.add(new Building(buildingName, toAddNeighbors));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }
    }
}