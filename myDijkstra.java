import java.util.ArrayList;

//class that implements Dijkstra's Algorithm
public class myDijkstra {
    
    public static void createPaths(World w, Building start, Building end) {

        //create list of visited vertices
        ArrayList<Building> visitedBuildings = new ArrayList<Building>();
        //create list of unvisited vertices
        ArrayList<Building> unvisitedBuildings = w.totalBuildings;

        //Create BuildingDirection table
        ArrayList<BuildingDirection> table = new ArrayList<BuildingDirection>(unvisitedBuildings.size());
        table.add(new BuildingDirection(start, 0, start));
        unvisitedBuildings.remove(start);
        for (Building b : unvisitedBuildings) {
            table.add(new BuildingDirection(b, 1000, null));
        }
        unvisitedBuildings.add(start);
        //Main algorithm
        while (unvisitedBuildings.size() > 0) {
            ArrayList<String> unvisitedBuildingsNames = new ArrayList<String>();
            for (Building b : unvisitedBuildings) {
                unvisitedBuildingsNames.add(b.name);
            }
            //Find starting Building
            Building currentBuilding = null;
            int furthestDistance = 99999;
            for (BuildingDirection b : table) {
                if (!visitedBuildings.contains(b.building)) {
                    if (b.distanceStart < furthestDistance) {
                        furthestDistance = b.distanceStart;
                        currentBuilding = b.building;
                    }
                }
            }

            for (Neighbor n : currentBuilding.neighbors) {
                if (unvisitedBuildingsNames.contains(n.nameNeighbor)) {
                    for (BuildingDirection b : table) {
                        if (b.building.name.equals(n.nameNeighbor)) {
                            for (BuildingDirection bd : table) {
                                if (bd.building.name.equals(currentBuilding.name)) {
                                    int proposedDistance = bd.distanceStart + n.edgeLength;
                                    if (proposedDistance < b.distanceStart) {
                                        b.distanceStart = proposedDistance;
                                        b.prevBuilding = currentBuilding;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            visitedBuildings.add(currentBuilding);
            unvisitedBuildings.remove(currentBuilding);
        }
        int distance = 0;
        for (BuildingDirection bd : table) {
            if (bd.building.name == end.name) distance = bd.distanceStart;
        }
        System.out.println("To get to " + end.name + " you must walk at least " + distance + " meters");
        System.out.println("The shortest path is " + start.name + shortestPath(start, end, table));
        timeEstimation(distance);
    }

    public static String shortestPath(Building start, Building end, ArrayList<BuildingDirection> table) {
        //Returning the actual path taken
        String result = "";
        Building compare = end;
        while (true) {
            for (BuildingDirection bd : table) {
                if (compare == bd.building) {
                    compare = bd.prevBuilding;
                    result = ", " + bd.building.name + result;
                }
            }
            if (compare == start) break;
        }
        return result;
    }

    //method that reads in user input of average walking speed
    public static double getStepLength(String prompt) {
        java.util.Scanner stepScanner = new java.util.Scanner(System.in);
        while (true)
        {
            try{
                System.out.println(prompt);
                double stepLength = stepScanner.nextDouble();
                return stepLength;
            }
            catch
            (java.util.InputMismatchException e)
            {
                System.out.println("Bad answer... try again.");
                stepScanner.nextDouble();
            }
        }
    }

    //method that returns an estimated time to walk from one building to another based on average step length
    public static void timeEstimation(int distance) {
        double unit = getStepLength("What is your average walking speed (mph): ");
        double toMPS = unit * 1609.34 / 3600;
        double timeinSeconds = distance/toMPS;
        int minutes = (int) (timeinSeconds/60);
        int seconds = (int) (timeinSeconds % 60);
        System.out.println("Your walking time is: " + minutes + " minutes and " + seconds  + " seconds");
    }
}