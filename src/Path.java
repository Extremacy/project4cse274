public class Path implements Comparable<Path> {
    public Vertex vertex;
    public String pathStr;
    public int cost;

    public Path (Vertex vertex, int cost, String endVet) {
        this.vertex = vertex;
        this.cost = cost;
        this.pathStr = endVet;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += vertex.toString() + ":";
        ret += cost + " ;";
        ret += pathStr + "?";
        return ret;
    }

    @Override
    public int compareTo(Path other) {
        return cost - other.cost;
    }

}
