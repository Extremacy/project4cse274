import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    //=================================================== Properties
    private static boolean totalCost;

    //=================================================== Internal Methods
    public static Path shortestPath(Graph graph, String start, String end) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        ArrayList<Vertex> visited = new ArrayList<>();

        pq.add(new Path(graph.vertices.get(start), 0, start));

        Path nextEntry = null;
        while (!pq.isEmpty()) {
            nextEntry = pq.remove();
            if (visited.contains(nextEntry.vertex))
                continue;
            visited.add(nextEntry.vertex);

            if (nextEntry.vertex == graph.vertices.get(end))
                return nextEntry;
            else {
                Vertex currVertex = nextEntry.vertex;
                String currPath = nextEntry.pathStr;
                int currCost = nextEntry.cost;
                for (Edge e : graph.edges) {
                    Vertex v = e.toVertex;
                    if (e.fromVertex == currVertex && !visited.contains(v)) {
                        int nextCost = currCost + e.distCost;
                        String nextPath = currPath + v.symbol;
                        pq.add(new Path(v, nextCost, nextPath));
                    }
                }
            }
        }

        return nextEntry;
    }
}
