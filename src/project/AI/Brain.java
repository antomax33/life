package project.AI;

import main.java.matrices.DMatrix;
import project.life.Action;
import project.matrix.MatrixUtil;

public final class Brain implements Thinkable {

    private final int height;
    private final int width;

    // Weights for a cell
    private final DMatrix w;
    private final DMatrix valeur;
    private final DMatrix output;
    private final DMatrix b;

    /**
     * To create a brain of a certain height and width.
     *
     * @param height number of information given.
     * @param width width of the machine learning.
     */
    public Brain (int height, int width){
        this(MatrixUtil.randn(height,width), MatrixUtil.randn(height,width));

        MatrixUtil.printMatrix(w, "W");
    }

    /**
     * To create a brain based on the weights.
     *
     * @param weight weight
     * @param biais biais
     */
    public Brain(DMatrix weight, DMatrix biais){
        if(!(1 <= weight.height() && 1 <= weight.width() &&
                weight.width()==biais.width() && weight.height() == biais.height()))
            throw new IllegalArgumentException();

        this.height = weight.height();
        this.width = weight.width();

        valeur = new DMatrix(height, width);
        output = new DMatrix(1,1);
        this.w = weight;
        this.b = biais;
    }

    /**
     * To clone a brain.
     *
     * @param brain old brain
     */
    public Brain(Brain brain){
        this(brain.getWeights(), brain.getBiais());
    }

    /**
     * To get a copy of the weights.
     *
     * @return a copy of the weights.
     */
    public DMatrix getWeights(){
        return w.clone();
    }

    /**
     * To get a copy of the biais.
     *
     * @return a copy of the biais.
     */
    public DMatrix getBiais(){
        return b.clone();
    }

    /**
     * Provide an action
     *
     * @param information information to treat like view on food or wall.
     * @return futur action
     */
    @Override
    public Action nextAction(Double[] information) {

        transmitInformation(information);
        MatrixUtil.printMatrix(valeur, "valeur");
        System.out.println(output.get(0,0));
        return null;
    }

    /**
     * Transmit the information from the input to the output.
     *
     * @param information information like vision or else.
     */
    private void transmitInformation(Double[] information){
        if(information.length != height)
            throw new IllegalArgumentException();

        // Set the first column of the matrice.
        for (int i = 0; i < information.length; i++) {
            valeur.set(i, 0, information[i]);
        }

        // Transmit the data to the next column
        for (int i = 0; i < width - 1; i++) {
            transmitCol(i);
        }
        transmitLastColumn();
    }

    /**
     * Transmit the data from the last column to the output
     */
    private void transmitLastColumn(){
        output.set(0,0, transmitCell(valeur.width()-1, 1));
    }

    /**
     * Transmit the data from one coloumn to the next one
     * @param fromCol start column.
     */
    private void transmitCol(int fromCol){
        for (int i = 0; i < valeur.height(); i++) {
            valeur.set(i, fromCol+1, transmitCell(fromCol, i));
        }
    }

    /**
     * Calculate the value for the next neurone.
     *
     * @param fromCol from column.
     * @param toRow to row.
     * @return x*w+b
     */
    private double transmitCell(int fromCol, int toRow){
        double nextValue = 0;
        for (int j = 0; j < valeur.height(); j++) {
            double a = valeur.get(j, fromCol);
            double b = w.get(j, toRow);
            System.out.println("a*b " + a + "*" + b);
            nextValue += a*b;
        }
        System.out.println("b " + b.get(toRow, fromCol));
        nextValue += b.get(toRow,fromCol);
        System.out.println("next value " + nextValue);
        return 1 / (1 + Math.exp( -nextValue));
    }
}
