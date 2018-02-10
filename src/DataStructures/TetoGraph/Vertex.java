package DataStructures.TetoGraph;


import java.util.List;

public class Vertex<T extends Comparable, K extends Comparable> {

    int id;
    T data;
    List<Vertex<T, K>> adjacentVertices;
    List<Edge<T, K>> adjacentEdges;

    Vertex(T data, List<Vertex<T, K>> adjacentVertices){
        this.setData(data);
        this.setAdjacentVertices(adjacentVertices);
    }

    public void addAdjacentVertex(Vertex<T, K> newVertex){
        adjacentVertices.add(newVertex);
    }

    public void addAdjacentEdge(Edge<T, K> newEdge){
        adjacentEdges.add(newEdge);
    }

    public Edge<T, K> getEdge(Vertex<T, K> neighbour){
        if(neighbour.getId() > this.getId()){
            for(Edge<T, K> edge : adjacentEdges){
                if(edge.getEndVertex() == neighbour){
                    return edge;
                }
            }
        }
        else{
            for(Edge<T, K> edge : adjacentEdges){
                if(edge.getEndVertex() == neighbour){
                    return edge;
                }
            }
        }
        return null;
    }

    public Vertex<T, K> getNeighbour(Edge<T, K> edge){
        if(edge.getEndVertex() == this){
            return edge.getStartVertex();
        }
        else{
            return edge.getEndVertex();
        }
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
