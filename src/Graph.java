import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class Graph {
    public static boolean useDistCost = true;
    public static boolean returnAddress = true;

    private Set<Edge> set = new HashSet<>();
    public HashMap<Vertex, Set<Edge>> vertices;

    public Graph (String fileName) {
        vertices = new HashMap<Vertex, Set<Edge>>();
        Vertex useVertex = new Vertex("Please", "Work") ;

        String[] parts;
        try (Scanner fin = new Scanner(new File(fileName))){
            while (fin.hasNextLine()) {
                parts = fin.nextLine().split("\t");
                if (parts[0].equals("<Nodes>")) {
                    fin.nextLine();
                    while (true) {
                        parts= fin.nextLine().split("\t");
                        if (parts[0].equals("</Nodes>"))		break;
                        Vertex vertex = new Vertex(parts[0], parts[1]); //this
                        vertices.put(vertex, set = new HashSet<>());
                    }
                } else if (parts[0].equals("<Edges>")) {
                    fin.nextLine();
                    while(true) {
                        Vertex vertFrom = null;/////
                        parts = fin.nextLine().split("\t");
                        if(parts[0].equals("</Edges>"))		break;
                        Set<Vertex> vertSet = vertices.keySet();
                        for (Vertex v: vertSet) {
                            if (v.getSymbol().equals(parts[1])) {

                                useVertex = v;

                            }
                        }

                        for (Vertex vert1 : vertSet) {
                            if (vert1.getSymbol().equals(parts[0])) {
                                vertFrom = vert1;
                                break;
                            }
                        }

                        Edge edges = new Edge(useVertex, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                        Set<Edge> prev = new HashSet<Edge>();
                        if (vertices.get(vertFrom) == null) {
                            prev.add(edges);
                        } else  {
                            for(Edge oldEdge : vertices.get(vertFrom))
                                prev.add(oldEdge);
                            prev.add(edges);
                        }
                        vertices.replace(vertFrom, prev);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Set ret2 = vertices.entrySet();
        for(Entry<Vertex, Set<Edge>> ret3: vertices.entrySet()) {
            //System.out.println(ret3);
            ret.append(ret3 + "\n");
        }

        Vertex findvert = null;
        Set<Vertex> vertSet = vertices.keySet();
        for (Vertex vert1 : vertSet) {
        }


        return ret.toString();
    }

    public Vertex getVertex(String sym) {
        Set<Vertex> vertSet = vertices.keySet();
        //Vertex ret = null;
        for (Vertex vert1 : vertSet) {
            if(vert1.getSymbol().equals(sym))
                return vert1;
        }
        return null;
    }


}
