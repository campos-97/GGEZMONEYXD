package DataStructures.Graphs;

import org.apache.commons.lang3.tuple.Triple;
import org.apache.xpath.SourceTree;

import java.util.List;
import java.util.Vector;

public class Node {

    private String roundHash;
    private String hashSalt;
    private double roundNumber;
    private String game;
    private String date;
    private String time;
    private String color;
    private int number;

    private static List<List> statistics;

    public Node(){
        roundHash = null;
        hashSalt = null;
        roundNumber = 0;
        game = null;
        date = null;
        time = null;
        color = null;
        number = 0;

        statistics = new Vector<>();
        statistics.add(new Vector<Node>());
        statistics.add(new Vector<List>());
    }

    public Node(String newRoundHash, String newHashSalt, double newRoundNumber,
                     String newGame, String newDate, String newTime, String newColor, int newNumber){
        roundHash = newRoundHash;
        hashSalt = newHashSalt;
        roundNumber = newRoundNumber;
        game = newGame;
        date = newDate;
        time = newTime;
        color = newColor;
        number = newNumber;

        statistics = new Vector<>();
        statistics.add(new Vector<Node>());
        statistics.add(new Vector<List>());
    }

    public static void addStatistic(Node otherNode, String attr, String similarity){
        statistics.get(0).add(otherNode);
        Vector attrInfo = new Vector();
        attrInfo.add(attr);
        attrInfo.add(similarity);
        statistics.get(1).add(attrInfo);
    }

    public void printNode(){
        System.out.println("Game: " + getGame() + "\n"
        + "Date: " + getDate() + "\n"
        + "Number: " + getNumber() + "\n"
        + "Color: " + getColor() + "\n"
        + "Round Number: " + getRoundNumber() + "\n"
        + "Round Hash: " + getRoundHash() + "\n"
        + "Hash Salt: " + getHashSalt() + "\n"
        );
    }

    public String getRoundHash() {
        return roundHash;
    }

    public void setRoundHash(String roundHash) {
        this.roundHash = roundHash;
    }

    public String getHashSalt() {
        return hashSalt;
    }

    public void setHashSalt(String hashSalt) {
        this.hashSalt = hashSalt;
    }

    public double getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(double roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
