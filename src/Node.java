import java.util.ArrayList;
import java.util.List;

public class Node {
    private boolean isVisited;
    private int dist;
    private ArrayList<Edge> edges;

    public Node() {
        this.isVisited = false;
        this.dist = Integer.MAX_VALUE;
        this.edges = new ArrayList<>();
    }

    public boolean isAvialableNotVisited(List<Node> nodes){
        for(Node node:nodes){
            if(!node.isVisited) {
                return true;
            }

        }
        return false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }


    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }



}
