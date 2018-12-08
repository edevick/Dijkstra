import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Edge>edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 7));
        edges.add(new Edge(0, 2, 9));
        edges.add(new Edge(0, 5, 14));
        edges.add(new Edge(5, 4, 9));
        edges.add(new Edge(2, 5, 2));
        edges.add(new Edge(2, 3, 11));
        edges.add(new Edge(1, 2, 10));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(5, 3, 6));
        edges.add(new Edge(3, 2, 6));
        edges.add(new Edge(5, 1, 6));
        Graph graph = new Graph(edges);
        graph.toFoundShortestDistance();
        System.out.println(graph.toString());

    }
}
