public class Path implements Comparable<Path> {
    //=================================================== Properties
    public Vertex vertex;
    public String pathStr;
    public int cost;

    //=================================================== Constructor Methods
    public Path(Vertex vertex, int cost, String pathStr) {
        this.vertex = vertex;
        this.cost = cost;
        this.pathStr = pathStr;
    }

    @Override
    public int compareTo(Path o) {
        return o.cost - cost;
    }

    @Override
    public String toString() {
        return pathStr;
    }
}
