import java.util.ArrayList;

public class myDijkstra {
    static Building A;
    static Building B;
    static Building C;
    static Building D;
    static Building E;
    static Building F;


    public static void main(String[] args) {
        createPaths();
    }


//public ArrayList<Building> createPaths(String s, ArrayList<Building> totalBuildings, ArrayList<Neighbor> totalNeighbors) {
    public static void createPaths() {
        Neighbor[] Aneighbors = new Neighbor[3];
        Aneighbors[0] = new Neighbor("B", 10);
        Aneighbors[1] = new Neighbor("F", 20);
        Aneighbors[2] = new Neighbor("E",2);
        A = new Building ("A", Aneighbors);

        Neighbor[] Bneighbors = new Neighbor[3];
        Bneighbors[0] = new Neighbor("A", 10);
        Bneighbors[1] = new Neighbor("E", 5);
        Bneighbors[2] = new Neighbor("C", 5);
        B = new Building ("B", Bneighbors);

        Neighbor[] Cneighbors = new Neighbor[2];
        Cneighbors[0] = new Neighbor("D", 2);
        Cneighbors[1] = new Neighbor("B", 5);
        C = new Building ("C", Cneighbors);

        Neighbor[] Dneighbors = new Neighbor[3];
        Dneighbors[0] = new Neighbor("C", 2);
        Dneighbors[1] = new Neighbor("E", 8);
        Dneighbors[2] = new Neighbor("F", 14);
        D = new Building ("D", Dneighbors);

        Neighbor[] Eneighbors = new Neighbor[3];
        Eneighbors[0] = new Neighbor("B", 5);
        Eneighbors[1] = new Neighbor("A", 2);
        Eneighbors[2] = new Neighbor("D", 8);
        E = new Building ("E", Eneighbors);

        Neighbor[] Fneighbors = new Neighbor[2];
        Fneighbors[0] = new Neighbor("A", 20);
        Fneighbors[1] = new Neighbor("D", 14);
        F = new Building ("F", Fneighbors);




        //create list of unvisited vertices
        ArrayList<Building> visitedBuildings = new ArrayList<Building>();

        //create list of visited vertices
//        ArrayList<Building> unvisitedBuildings = totalBuildings;
        ArrayList<Building> unvisitedBuildings = new ArrayList<Building>();
        unvisitedBuildings.add(A);
        unvisitedBuildings.add(B);
        unvisitedBuildings.add(C);
        unvisitedBuildings.add(D);
        unvisitedBuildings.add(E);
        unvisitedBuildings.add(F);


        //create list of buildings
        ArrayList<BuildingDirection> table = new ArrayList<BuildingDirection>(unvisitedBuildings.size());
        BuildingDirection Adirection = new BuildingDirection(A, 0, A);
        BuildingDirection Bdirection = new BuildingDirection(B, 100, null);
        BuildingDirection Cdirection = new BuildingDirection(C, 100, null);
        BuildingDirection Ddirection = new BuildingDirection(D, 100, null);
        BuildingDirection Edirection = new BuildingDirection(E, 100, null);
        BuildingDirection Fdirection = new BuildingDirection(F, 100, null);
        table.add(Adirection);
        table.add(Bdirection);
        table.add(Cdirection);
        table.add(Ddirection);
        table.add(Edirection);
        table.add(Fdirection);

        //Currently not needed
//        ArrayList<String> tableNames = new ArrayList<String>();
//        for (BuildingDirection bd : table) {
//            tableNames.add(bd.building.name);
//        }
        int i = 6;
        //unvisitedBuildings.size() > 0
        while (unvisitedBuildings.size() > 0) {
            ArrayList<String> unvisitedBuildingsNames = new ArrayList<String>();
            for (Building b : unvisitedBuildings) {
                unvisitedBuildingsNames.add(b.name);
            }
            Building currentBuilding = null;
            int furthestDistance = 99999;
            for (BuildingDirection b : table) {
                if (! visitedBuildings.contains(b.building)) {
                    if (b.distanceStart < furthestDistance) {
                        furthestDistance = b.distanceStart;
                        currentBuilding = b.building;
                    }
                }
            }

            for (Neighbor n : currentBuilding.neighbors) {
//                System.out.println("mitch");
                if (unvisitedBuildingsNames.contains(n.nameNeighbor)) {
                    for (BuildingDirection b : table) {
//                        System.out.println("fool");
                        if (b.building.name.equals(n.nameNeighbor)) {
                            for (BuildingDirection bd : table) {
//                                System.out.println("mike");
                                if (bd.building.name.equals(currentBuilding.name)) {
//                                    System.out.println("yo mama");
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

        for (BuildingDirection bd : table) {
            System.out.println(bd.building.name + ": shortest distance from A is: " + bd.distanceStart);
            System.out.println("The previous building is: " + bd.prevBuilding.name);
        }


    }



//        //create a list of neighbors
//        ArrayList<Neighbor> neighbors = totalNeighbors;


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
//        Neighbor[] startNeighbors = new Neighbor[unvisitedBuildings.size()];
//        Building startBuilding = new Building(s, startNeighbors);
//        //startIndex will be used
//        int startIndex = 0;
//        for (int i = 0; i < unvisitedBuildings.size(); i++) {
//            if (unvisitedBuildings.get(i).name == s) {
//                table.set(0, startBuilding);
//                startIndex = i;
//                for (int j = i%unvisitedBuildings.size(); j < i; j++) {
//                    Building currBuilding = new Building(unvisitedBuildings.get(j).name, startNeighbors);
//                    table.set(j-i, currBuilding);
//                }
//                break;
//            }
//
//        }
//
//        //create the possible paths in table
//        int arrayIndex = 0;
//        for (int i = startIndex%unvisitedBuildings.size(); i < startIndex; i++) {
//            for (int j = 0; j < unvisitedBuildings.size(); j++) {
//                if (unvisitedBuildings.get(i).name == neighbors.get(i).neighbor) {
//                    unvisitedBuildings.get(i).setNeighbor(neighbors.get(i), arrayIndex);
//                    arrayIndex++;
//                }
//            }
//            arrayIndex = 0;
//        }
//
//        return table;

    }



//    public ArrayList<String> getShortestPath(String startingPoint, String finalDestination, String s, ArrayList<Building> totalBuildings, ArrayList<Neighbor> totalNeighbors) {
//        ArrayList<Building> possiblePaths = createPaths(s, totalBuildings, totalNeighbors);
//        ArrayList<String> shortestPath = new ArrayList<String>();
//        int totalDistance = 0;
//
//        shortestPath.add(0, startingPoint);
//
//        String locationName = startingPoint;
//
//        //find starting building
//        for (int i = 0; i < )
//
//        System.out.println(totalDistance);
//        return shortestPath;
//
//    }
//}
