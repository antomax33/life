package project.AI;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class Math2 {

    public final static Random random = new Random(0);
    public static double clamp(double min, double value, double max){
        if(value <= min){return min;}
        return Math.min(value, max);
    }


    public static double[] randomArray(int size){
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextGaussian();
        }
        return array;
    }

    public static double[][] randomArray(int size1, int size2){
        double array[][] = new double[size1][size2];
        for (int i = 0; i < size1; i++) {
            array[i] = randomArray(size2);
        }
        return array;
    }

    public static double[][][] randomArray(int size1, int size2, int size3){
        double array[][][] = new double[size1][size2][size3];
        for (int i = 0; i < size1; i++) {
            array[i] = randomArray(size2, size3);
        }
        return array;
    }

    public static String arrayToString(double[] array){
        return Arrays.toString(array);
    }

    public static String arrayToString(double[][] array){
        StringJoiner sj = new StringJoiner("\n", "[", "]");
        for (double[] arr : array) {
            sj.add(arrayToString(arr));
        }
        return sj.toString();
    }
    public static String arrayToString(double[][][] array){
        StringJoiner sj = new StringJoiner("\n\n", "[", "]");
        for (double[][] arr : array) {
            sj.add(arrayToString(arr));
        }
        return sj.toString();
    }
    public static void printArray(double[] array, String name){
        System.out.println(name + " size :" + array.length);
        System.out.println(arrayToString(array));
    }

    public static void printArray(double[][] array, String name){
        System.out.println(name + " size :" + array.length + " " + array[0].length);
        System.out.println(arrayToString(array));
    }

    public static void printArray(double[][][] array, String name){
        System.out.println(name + "size :" + array.length + " " + array[0].length + " " +
                array[0][0].length);
        System.out.println(arrayToString(array));
    }

    public static double[][] clone(double[][] array){

        double[][] clone = new double[array.length][];
        for(int i = 0; i < array.length; i++)
        {
            double[] aMatrix = array[i];
            int aLength = aMatrix.length;
            clone[i] = new double[aLength];
            System.arraycopy(aMatrix, 0, clone[i], 0, aLength);
        }

        return clone;
    }

    public static double[][][] clone(double[][][] array){
        double[][][] clone = new double[array.length][][];
        for(int i = 0; i < array.length; i++)
        {
            clone[i] = clone(array[i]);
        }

        return clone;
    }


}
