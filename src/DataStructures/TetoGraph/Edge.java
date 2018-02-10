package DataStructures.TetoGraph;

public class Edge<T extends Comparable, K extends Comparable> {

    boolean direction;
    K weight;
    Vertex<T, K> startVertex;
    Vertex<T, K> endVertex;

    Edge(boolean direction, Vertex<T, K> vertexOne, Vertex<T, K> vertexTwo, K weight) {
        this.setStartVertex(vertexOne);
        this.setEndVertex(vertexTwo);
        this.setWeight(weight);
    }

    public K getWeight() {
        return weight;
    }
    public void setWeight(K weight) {
        this.weight = weight;
    }

    public boolean isDirection() {
        return direction;
    }
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public Vertex<T, K> getStartVertex() {
        return startVertex;
    }
    public void setStartVertex(Vertex<T, K> startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex<T, K> getEndVertex() {
        return endVertex;
    }
    public void setEndVertex(Vertex<T, K> endVertex) {
        this.endVertex = endVertex;
    }

}
