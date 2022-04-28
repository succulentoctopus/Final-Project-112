import java.util.ArrayList;

public class myDijkstra {

    public void createPaths(String s, int numBuildings) {
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

    }

    public ArrayList<String> getShortestPath(String startingPoint, String finalDestination) {
        ArrayList<String> path = new ArrayList<String>();
        path.add(0, finalDestination);

        String locationName = finalDestination;

        while (locationName != startingPoint) {

        }

        return path;

    }
}
