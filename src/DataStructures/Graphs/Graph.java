package DataStructures.Graphs;

import java.util.List;
import java.util.Vector;

public class Graph {

    private static List<Node> nodes;
    private Node lastNode;
    private static int[][] matrix;

    public Graph(){
        nodes = new Vector<>();
        lastNode = null;
        matrix = new int[15][15];
        printMatrix();
    }

    public Graph(Node newNode){
        this();
        nodes.add(newNode);

    }


    public static void printMatrix(){
        String str = "*   ";
        int i = 0;
        for(int j = 0; j < 15; j++){
            str += j + "   ";
        }
        str += "   \n";
        for(int[] vec :  matrix){
            str += i++ + "   ";
            for(int num : vec){
                str += num + "   ";
            }
            str += "\n";
        }
        System.out.println(str);
    }

    public void addNode(String newRoundHash, String newHashSalt, double newRoundNumber,
                               String newGame, String newDate, String newTime, String newColor, int newNumber){
        Node newNode = new Node(newRoundHash, newHashSalt, newRoundNumber, newGame, newDate, newTime,
                newColor, newNumber);
        addNode(newNode);

    }

    public void addNode(Node node){
        compareNewNode(node);
        lastNode = node;
        printMatrix();
        //nodes.add(node);
    }

    private void compareNewNode(Node newNode){
       if(lastNode != null){
           System.out.println(lastNode.getNumber()+"    "+newNode.getNumber());
           matrix[lastNode.getNumber()][newNode.getNumber()]++;
       }
    }


}
