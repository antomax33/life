package project.matrix;

import main.java.matrices.DMatrix;
import main.java.matrices.Matrix;

import java.util.Random;
import java.util.StringJoiner;

public class MatrixUtil {
    public static DMatrix randn(int height, int width){


        Random random = new Random(0);
        DMatrix m = new DMatrix(height, width);
        m.map(x -> random.nextGaussian());
        return m;
    }

    public static void printMatrix(Matrix matrix, String name){

        System.out.println(name + " is of size [" + matrix.height() + " X " + matrix.width() + "]");

        StringJoiner sjHeight = new StringJoiner("\n", "[", "]");
        for (int i = 0; i < matrix.height(); i++) {
            StringJoiner sjWidht = new StringJoiner(",", "[", "]");
            for (int j = 0; j < matrix.width(); j++) {
                sjWidht.add(matrix.get(i,j).toString());
            }
            sjHeight.add(sjWidht.toString());
        }
        System.out.println(sjHeight);
    }

    public static void printMatrix(Matrix matrix){printMatrix(matrix, "Matrix");}
}
