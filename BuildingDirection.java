/*The objects in this class are the main basis for Dijkstra's algorithm
They are objects with attributes Building, an integer value that is the distance between this building and the
starting point, and a reference to the immediate previous building.
 */

public class BuildingDirection {
    Building building;
    int distanceStart;
    Building prevBuilding;

    //constructor for the class
    public BuildingDirection(Building a, int b, Building c) {
        building = a;
        distanceStart = b;
        prevBuilding = c;
    }
}
