package project.AI;

public class Math2 {

    public static double clamp(double min, double value, double max){
        if(value <= min){return min;}
        return Math.min(value, max);
    }



}
