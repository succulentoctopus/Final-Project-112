public class Building {
    String name;
    Neighbor[] neighbors;

    public Building(String n, Neighbor[] n1) {
        name = n;
        neighbors = n1;
    }

    public void setNeighbor(Neighbor n, int index) {
        this.neighbors[index] = n;
    }


}
