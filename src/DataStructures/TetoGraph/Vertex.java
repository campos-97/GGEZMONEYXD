package DataStructures.TetoGraph;


import java.util.List;

public class Vertex<T> {
    T data;
    List<Vertex<T>> adjacentVertices;
    List<Edge<T>> adjacentEdges;
}
