/*class that implements the idea of Neighbors
the attributes of the objects in this class are the name of the neighbor (to an object thisBuilding) and the
distance from the neighbor to thisBuilding
 */

public class Neighbor {
    String nameNeighbor;
    int edgeLength;

    //constructor for Neighbor
    public Neighbor(String n, int e) {
        nameNeighbor = n;
        edgeLength = e;
    }

    //toString method that returns the name of the neighbor and its distance from thisBuilding
    public String toString() {
        return this.nameNeighbor + " " + edgeLength + " ";
    }
}
