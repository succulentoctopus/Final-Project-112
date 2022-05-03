public class Neighbor {
    String nameNeighbor;
    int edgeLength;
    public Neighbor(String n, int e) {
        nameNeighbor = n;
        edgeLength = e;
    }

    public String toString() {
        return this.nameNeighbor + " " + edgeLength + " ";
    }
}
