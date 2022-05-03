import java.util.ArrayList;

public class Building {
    String name;
    ArrayList<Neighbor> neighbors;

    public Building(String n, ArrayList<Neighbor> n1) {
        name = n;
        neighbors = n1;
    }

    public String toString() {
        String result = "thisBuilding " + this.name + " has neighbors ";
        for (Neighbor n : neighbors) {
            result += n;
        }
        return result;
    }

}
//public class Building {
//    String name;
//    Neighbor[] neighbors;
//
//    public Building(String n, Neighbor[] n1) {
//        name = n;
//        neighbors = n1;
//    }
//
//    public void setNeighbor(Neighbor n, int index) {
//        this.neighbors[index] = n;
//    }
//
//
//}
