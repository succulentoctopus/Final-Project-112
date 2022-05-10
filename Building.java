import java.util.ArrayList;

public class Building {
    String name;
    ArrayList<Neighbor> neighbors;

    public Building(String n, ArrayList<Neighbor> n1) {
        name = n;
        neighbors = n1;
    }

    public String toString() {
        String result = "this building " + this.name + " has neighbors ";
        for (Neighbor n : neighbors) {
            result += n;
        }
        return result;
    }
}