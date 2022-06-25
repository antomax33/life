package project.AI;

import main.java.matrices.DMatrix;
import project.life.Action;
import project.matrix.MatrixUtil;

public final class Brain implements Thinkable {

    //private final int height;
    //private final int width;

    // Weights
    private double w[][][];
    private double valeur[][];
    private double output[];
    private double b[][];

    /**
     * To create a brain of a certain height and width.
     *
     * @param height number of information given.
     * @param width width of the machine learning.
     */
    public Brain (int height, int width){
        this(MatrixUtil.randn(height,width), MatrixUtil.randn(height,width));
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
        return null;
    }

    /**
     * To get a copy of the biais.
     *
     * @return a copy of the biais.
     */
    public DMatrix getBiais(){
        return null;
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
        return null;
    }

    /**
     * Transmit the information from the input to the output.
     *
     * @param information information like vision or else.
     */
    private void transmitInformation(Double[] information){
        //if(information.length != height)
        //    throw new IllegalArgumentException();

        // Set the first column of the matrice.


        // Transmit the data to the next column
    }

    /**
     * Transmit the data from the last column to the output
     */
    private void transmitLastColumn(){
    }

    /**
     * Transmit the data from one coloumn to the next one
     * @param fromCol start column.
     */
    private void transmitCol(int fromCol){
    }

    /**
     * Calculate the value for the next neurone.
     *
     * @param fromCol from column.
     * @param toRow to row.
     * @return x*w+b
     */
    private double transmitCell(int fromCol, int toRow){
        return 0;
    }
}
