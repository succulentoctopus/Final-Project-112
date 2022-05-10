import java.util.ArrayList;

public class myDijkstra {

    public static void main(String[] args) {
        //Display the picture
        new DisplayPicture();
        //Create the graph
        World w = new World("AmherstCampus");
        //Ask for starting and ending location
        String s = getUserString("What is the name of your starting location? Type it out exactly as it appears on the map", w);
        String e = getUserString("Which building do you want to end up at?", w);
        Building starting = null;
        Building ending = null;
        for (Building b : w.totalBuildings) {
            if (b.name.equals(s)) starting = b;
            if (b.name.equals(e)) ending = b;
        }
        //Run Alogrithm
        createPaths(w, starting, ending);

    }

    public static String getUserString(String prompt, World w) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        ArrayList<String> buildingNames = new ArrayList<String>();
        for (Building b : w.totalBuildings) {
            buildingNames.add(b.name);
        }
        while (true) {
            try {
                System.out.println(prompt);
                String result = scan.nextLine();
                while (true) {
                    if (buildingNames.contains(result)) {
                        break;
                    } else {
                        //Makes sure user inputted acceptable building name
                        System.out.println("Not an acceptable building or typo, try again");
                        result = scan.nextLine();
                    }
                }
                return result;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Bad answer... try again.");
                scan.nextLine();
            }
        }
    }

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
}