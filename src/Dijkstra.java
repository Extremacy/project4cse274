import java.util.Set;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Dijkstra {

    static int totalCost;


    public static Path shortestPath(Graph g, String frm, String to, Boolean useDistCost) {

        PriorityQueue<Path> paths = new PriorityQueue<Path>();
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        Set<Vertex> verts = g.vertices.keySet();
        Vertex src = null;
        for (Vertex v : verts) {
            if (v.symbol.equals(frm)) {
                src = v;
                break;
            }
        }

        paths.add(new Path(src, 0, frm));
        Path nextEntry = null;
        while(!paths.isEmpty()) {
            nextEntry = paths.remove();
            if (visited.contains(nextEntry.vertex))
                continue;
            visited.add(nextEntry.vertex);
            if (nextEntry.vertex == g.vertices.get(to))
                return nextEntry;
            else {
                Vertex currVertex = nextEntry.vertex;
                String currPath = nextEntry.pathStr;
                int currCost = nextEntry.cost;
                for (Edge e : g.vertices.get(currVertex)) {
                    if (!visited.contains(e)) {
                        if(useDistCost) {
                            int nextCost = currCost + e.distCost;
                            String nextPath = currPath + e.getStartPt().symbol;
                            paths.add(new Path(e.getStartPt(), nextCost, nextPath));
                            totalCost = nextCost;
                        } else {
                            int nextCost = currCost + e.timeCost;
                            String nextPath = currPath + e.getStartPt().symbol;
                            paths.add(new Path(e.getStartPt(), nextCost, nextPath));
                            totalCost = nextCost;
                        }
                    }
                }
            }
        }
        return nextEntry;
    }
}

