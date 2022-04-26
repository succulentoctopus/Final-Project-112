public class Node {
    String buildingName;
    Pair xBound;
    Pair yBound;

    public Node(String name, Pair x, Pair y) {
        buildingName = name;
        xBound = x;
        yBound = y;
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