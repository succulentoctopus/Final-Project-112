import java.util.ArrayList;

public class myDijkstra {

    public ArrayList<Building> createPaths(String s, ArrayList<Building> totalBuildings) {
        //create list of unvisited vertices
        ArrayList<String> visitedBuildings = new ArrayList<String>();

        //create list of visited vertices
        ArrayList<Building> unvisitedBuildings = totalBuildings;

        //create list of buildings
        ArrayList<Building> table = new ArrayList<Building>(unvisitedBuildings.size());


        /*
        table.get(0).distance = 0;
        table.get(0).prev = table.get(0).name;

        for (int i = 1; i < numBuildings; i++) {
            table.get(i).distance = 100000;
            table.get(i).prev = null;
        }

        for (int i = 0; i < unvisitedBuildings.size(); i++) {
            visitedBuildings.add(unvisitedBuildings.get(i));
            unvisitedBuildings.remove(i);

            for (int j = 0; j < unvisitedBuildings.size(); j++) {

            }
        }

         */

        //find the starting building and initialize rest of table
        //create an empty Neighbor array that will be used to initalize every Building
        Neighbor[] startNeighbors = new Neighbor[unvisitedBuildings.size()];
        Building startBuilding = new Building(s, startNeighbors);
        //startIndex will be used
        int startIndex = 0;
        for (int i = 0; i < unvisitedBuildings.size(); i++) {
            if (unvisitedBuildings.get(i).name == s) {
                table.set(0, startBuilding);
                startIndex = i;
                for (int j = i%unvisitedBuildings.size(); j < i; j++) {
                    Building currBuilding = new Building(unvisitedBuildings.get(j).name, startNeighbors);
                    table.set(j-i, currBuilding);
                }
                break;
            }

        }

        //create the possible paths in table
        for (int i = startIndex%unvisitedBuildings.size(); i < startIndex; i++) {
            for (int j = 0; j < unvisitedBuildings.size(); j++) {
                if (unvisitedBuildings.get(i).name =)
            }
        }



        return table;

    }



    public ArrayList<String> getShortestPath(String startingPoint, String finalDestination) {
        ArrayList<Building> possiblePaths = createPaths(startingPoint, 30);
        ArrayList<String> shortestPath = new ArrayList<String>();
        int totalDistance = 0;

        shortestPath.add(0, startingPoint);

        String locationName = startingPoint;

        while (locationName != finalDestination) {

        }

        return shortestPath;

    }
}
