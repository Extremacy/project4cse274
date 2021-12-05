import java.util.Scanner;
import java.util.Set;

/**
 * @author PJ Duimstra, Berk Reasor
 */

public class Tester {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String file, input = "";
        Dijkstra test = null;
        String to, from = "";

        System.out.print("Please Input your file: ");
        file = kb.next();
        Graph g = new Graph(file);
        System.out.println("Graph for reference: ");
        System.out.println(g);


        System.out.print("Where are you currently?: ");
        from = kb.next();
        Vertex findvert = null;
        Set<Vertex> vertSet = g.vertices.keySet();
        for (Vertex vert1 : vertSet) {
            if (vert1.getSymbol().equals(from)) {
                findvert = vert1;
                break;
            }
        }



        Set<Edge> ret = g.vertices.get(findvert);

        System.out.print("What is your destination?: ");
        to = kb.next();

        Path ts = Dijkstra.shortestPath(g, from, to, true);


        System.out.println("Shortest path: " + ts.toString());
    }
}
