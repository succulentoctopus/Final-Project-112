import java.util.ArrayList;

//class of objects that represent a building and its neighbors
public class Building {
    String name;
    ArrayList<Neighbor> neighbors;

    //constructor for Building
    public Building(String n, ArrayList<Neighbor> n1) {
        name = n;
        neighbors = n1;
    }

    //method that returns a String of the building and the names of its Neighbors
    public String toString() {
        String result = "this building " + this.name + " has neighbors ";
        for (Neighbor n : neighbors) {
            result += n;
        }
        return result;
    }
}