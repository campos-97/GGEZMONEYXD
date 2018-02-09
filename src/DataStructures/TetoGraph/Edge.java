package DataStructures.TetoGraph;

public class Edge<T> {



    boolean direction;
    Vertex<T> startVertex;
    Vertex<T> endVertex;

    public boolean isDirection() {
        return direction;
    }
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public Vertex<T> getStartVertex() {
        return startVertex;
    }
    public void setStartVertex(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex<T> getEndVertex() {
        return endVertex;
    }
    public void setEndVertex(Vertex<T> endVertex) {
        this.endVertex = endVertex;
    }
}
