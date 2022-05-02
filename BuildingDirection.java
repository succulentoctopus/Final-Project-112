public class BuildingDirection {
    Building building;
    int distanceStart;
    Building prevBuilding;

    public BuildingDirection(Building a, int b, Building c) {
        building = a;
        distanceStart = b;
        prevBuilding = c;
    }
}
