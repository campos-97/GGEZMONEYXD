package algorithms.math;

public class Percentage {
    public static double getPercentage(int[] data, int center){
        double percentage = 0;
        for(int current : data){
            percentage += current;
        }
        return data[center]/(percentage)*100;
    }
}
