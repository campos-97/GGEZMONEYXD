package DataStructures.TetoGraph;

import java.util.PriorityQueue;

public class Maincito {
    public static void main(String[] args){
        TetoGraph<String, Integer> graph = new TetoGraph<>();
        Integer[] dss = {2, 5, 8};
        graph.addVertex("A", null, dss);
        graph.addVertex("B", null, dss);
        graph.addVertex("C", null, dss);
        String[] anus = {"A", "B", "C"};
        graph.addVertex("D", graph.getIDs(anus), dss);
    }

}
