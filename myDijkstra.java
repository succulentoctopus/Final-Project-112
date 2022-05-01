import java.util.ArrayList;

public class myDijkstra {

    public ArrayList<Building> createPaths(String s, int numBuildings) {
        //create list of unvisited vertices
        ArrayList<String> visitedBuildings = new ArrayList<String>();

        //create list of visited vertices
        ArrayList<String> unvisitedBuildings = new ArrayList<String>(numBuildings);

        //create list of buildings
        ArrayList<Building> table = new ArrayList<Building>(numBuildings);
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
