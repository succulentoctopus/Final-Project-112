public class Node {
    String buildingName;
    Neighbor[] neighbors;

    public Node(String name, Neighbor[] n) {
        buildingName = name;
        neighbors = n;
    }
}

class Pair {
    int lower;
    int upper;

    public Pair(int l, int u) {
        lower = l;
        upper = u;
    }
}