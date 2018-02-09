package DataStructures.TetoGraph;


import java.util.List;

public class Vertex<T, K extends Comparable> {

    int id;
    T data;
    List<Vertex<T, K>> adjacentVertices;
    List<Edge<T, K>> adjacentEdges;

    Vertex(T data, List<Vertex<T, K>> adjacentVertices){
        this.setData(data);
        this.setAdjacentVertices(adjacentVertices);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public List<Vertex<T, K>> getAdjacentVertices() {
        return adjacentVertices;
    }
    public void setAdjacentVertices(List<Vertex<T, K>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public List<Edge<T, K>> getAdjacentEdges() {
        return adjacentEdges;
    }
    public void setAdjacentEdges(List<Edge<T, K>> adjacentEdges) {
        this.adjacentEdges = adjacentEdges;
    }

}
