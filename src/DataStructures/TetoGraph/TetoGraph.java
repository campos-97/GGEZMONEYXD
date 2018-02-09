package DataStructures.TetoGraph;

import java.util.LinkedList;
import java.util.List;

public class TetoGraph<T, K extends Comparable> {

    int size = 0;
    List<Vertex<T, K>> vertexList;
    List<Edge<T, K>> edgesList;

    public Vertex<T, K> getVertex(int vertexID){
        for(Vertex<T> currentVertex : vertexList){
            if(currentVertex.getId() == vertexID){
                return currentVertex;
            }
        }
        return null;
    }

    public void setVertex(Vertex<T, K> newVertex, int[] verticesIDs){
        List<Vertex<T, K>> vertices = new LinkedList<Vertex<T, K>>();
        List<Edge<T, K>> edges = new LinkedList<Edge<T, K>>();
        for(int id : verticesIDs){
            Vertex<T, K> v = getVertex(id);
            if(v != null){
                vertices.add(v);
                Edge<T, K> e = new Edge<T, K>(false, newVertex, v);
                v.addAdjacentVertex(newVertex);
                v.addAdjacentEdge(e);
                edgesList.add(e);
            }
        newVertex.setAdjacentEdges(edges);
        newVertex.setAdjacentVertices(vertices);
        }

    }

    public void addVertex(T data, int[] verticesIDs){
        Vertex<T, K> newVertex = new Vertex<T, K>(data, null);
        setVertex(newVertex, verticesIDs);

    }

    private void addVertexAuxiliar(Vertex<T, K> newVertex){
        newVertex.setId(size++);
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public List<Vertex<T, K>> getVertexList() {
        return vertexList;
    }
    public void setVertexList(List<Vertex<T, K>> vertexList) {
        this.vertexList = vertexList;
    }

    public List<Edge<T, K>> getEdgesList() {
        return edgesList;
    }
    public void setEdgesList(List<Edge<T, K>> edgesList) {
        this.edgesList = edgesList;
    }

}
