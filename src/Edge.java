public class Edge {
    private int vertexFrom;
    private int vertexTo;
    private int length;


    public Edge(int vertexFrom, int vertexTo, int length) {
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.length = length;
    }

    public int getIndexesFromCloseVertexes(int nodeIndex) {//получаем индекс соседа
        if (this.vertexFrom == nodeIndex) {
            return this.vertexTo;
        } else {
            return this.vertexFrom;
        }
    }

    public int getVertexFrom() {
        return vertexFrom;
    }

    public void setVertexFrom(int vertexFrom) {
        this.vertexFrom = vertexFrom;
    }

    public int getVertexTo() {
        return vertexTo;
    }

    public void setVertexTo(int vertexTo) {
        this.vertexTo = vertexTo;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
