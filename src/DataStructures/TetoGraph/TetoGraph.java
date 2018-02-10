package DataStructures.TetoGraph;

import java.util.LinkedList;
import java.util.List;

public class TetoGraph<T extends Comparable, K extends Comparable> {

    int size = 0;
    List<Vertex<T, K>> vertexList;
    List<Edge<T, K>> edgesList;

    TetoGraph(){
        vertexList = new LinkedList<>();
        edgesList = new LinkedList<>();
    }

    public Vertex<T, K> getVertexWithId(int vertexID){
        for(Vertex<T, K> currentVertex : vertexList){
            if(currentVertex.getId() == vertexID){
                return currentVertex;
            }
        }
        return null;
    }
    public Vertex<T, K> getVertexWithData(T data){
        for(Vertex<T, K> vertex : vertexList){
            if(vertex.getData().compareTo(data) == 0){
                return vertex;
            }
        }
        return null;
    }

    private void setVertex(Vertex<T, K> newVertex, int[] verticesIDs, K[] weights){
        List<Vertex<T, K>> vertices = new LinkedList<Vertex<T, K>>();
        List<Edge<T, K>> edges = new LinkedList<Edge<T, K>>();
        int i = 0;
        if(verticesIDs != null){
            for(int id : verticesIDs){
                Vertex<T, K> v = getVertexWithId(id);
                if(v != null){
                    K weight = null;
                    vertices.add(v);
                    if(i < weights.length){
                        weight = weights[i++];
                    }
                    Edge<T, K> e = new Edge<T, K>(false, newVertex, v, weight);
                    edges.add(e);
                    v.addAdjacentVertex(newVertex);
                    v.addAdjacentEdge(e);
                    edgesList.add(e);
                }
            }
        }
        newVertex.setAdjacentEdges(edges);
        newVertex.setAdjacentVertices(vertices);
    }

    public void addVertex(T data, int[] verticesIDs, K[] weights){
        Vertex<T, K> newVertex = new Vertex<T, K>(data, null);
        newVertex.setId(size++);
        setVertex(newVertex, verticesIDs, weights);
        vertexList.add(newVertex);

    }

    public int[] getIDs(T[] dataArray){
        int[] ids = new int[dataArray.length];
        int i = 0;
        for(T data : dataArray){
            Vertex<T, K> v = getVertexWithData(data);
            if(v != null){
                ids[i++] = v.getId();
            }
            else{
                ids[i++] = -1;
            }
        }
        return ids;
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
