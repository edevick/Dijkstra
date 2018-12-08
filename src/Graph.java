import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edges = new ArrayList<>();
    private List<Node> nodes  = new ArrayList<>();
    public int countEdges;
    private int countNodes = 0;

    public Graph(List<Edge> edges) {
        this.edges = edges;
        this.countEdges = edges.size();
        this.countNodes = toCountNodes();
        toCreateNodes();
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public int getCountEdges() {
        return countEdges;
    }

    public void setCountEdges(int countEdges) {
        this.countEdges = countEdges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdges(List<Edge> edges) {
        this.edges = edges;
    }

    private void toCreateNodes() {
        for (int i = 0; i < countNodes; i++) {
            nodes.add(new Node());
        }
    }

    private int toCountNodes() {
        for (int i = 0; i < edges.size(); i++) {
            if (this.edges.get(i).getVertexFrom() > countNodes)
                countNodes=this.edges.get(i).getVertexFrom() ;
            if (this.edges.get(i).getVertexTo() > countNodes)
                countNodes=this.edges.get(i).getVertexTo() ;
        }

        return countNodes;
    }

    public void toFoundShortestDistance() {

        this.nodes.get(0).setDist(0);

        int nextNodeIndex = 0;
        for (int i = 0; i < this.countNodes; i++) {
            ArrayList<Edge> edges = this.nodes.get(nextNodeIndex).getEdges();
            for (Edge edge : edges) {
                int neighborNodeIndex = edge.getIndexesFromCloseVertexes(nextNodeIndex);
                if (!this.nodes.get(neighborNodeIndex).isVisited()) {//
                    int cost = this.nodes.get(nextNodeIndex).getDist() + edge.getLength();
                    if (cost < nodes.get(neighborNodeIndex).getDist()) {
                        this.nodes.get(neighborNodeIndex).setDist(cost);
                    }
                }
            }

            this.nodes.get(nextNodeIndex).setVisited(true);//устанавливаем текущий узел как посещенный
            nextNodeIndex = getClosestAvailableNode();//получаем новуый текущий узел
        }

    }



    private int getClosestAvailableNode() {
        int nodeIndex = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < this.countNodes; i++) {
            int currentDistance = this.nodes.get(i).getDist();
            if (!this.nodes.get(i).isVisited() && currentDistance < distance) {
                distance = currentDistance;
                nodeIndex = i;
            }
        }
        return nodeIndex;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Edge edge: this.edges) {
            stringBuilder.append("The shortest length is ")
                    .append(edge.getLength())
                    .append(" from node#")
                    .append(edge.getVertexFrom())
                    .append(" to the node #")
                    .append(edge.getVertexTo())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

}
