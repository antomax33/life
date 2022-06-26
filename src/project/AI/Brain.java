package project.AI;

import project.life.Action;

public final class Brain implements Thinkable {

    private final int height;
    private final int width;

    // Weights (width, height, height).
    private final double[][][] weight;
    // Biais (width, height).
    private final double[][] biais;
    // Weight for the last connection.
    private final double[][] finalWeight;
    // Biais for the last connection.
    private final double[] finalBiais;

    /**
     * Provide an action
     *
     * @param information information to treat like view on food or wall.
     * @return future action.
     */
    @Override
    public Action nextAction(double[] information) {

        transmitInformation(information);
        return null;
    }

    /**
     * To create a brain of a certain height and width.
     *
     * @param height number of information given.
     * @param width width of the machine learning.
     */
    public Brain (int height, int width){
        this(Math2.randomArray(width,height,height), Math2.randomArray(width, height),
                Math2.randomArray(width, height), Math2.randomArray(height));
    }

    /**
     * To create a brain based on the weights.
     *
     * @param weight weight
     * @param biais biais
     */
    public Brain(double[][][] weight, double[][] biais, double[][] finalWeight, double[] finalBiais){
        // Weights (width, height,height)
        // Biais (width, height)
        if(!(0 < weight.length &&
             0 < weight[0].length &&
             0 < biais.length &&
             0 < biais[0].length &&

            0 < finalWeight.length &&
            0 < finalWeight[0].length &&
            0 < finalBiais.length &&

             weight[0].length == weight[0][0].length &&
             weight[0].length == biais[0].length &&
             weight.length == biais.length))
            throw new IllegalArgumentException();

        this.weight = weight;
        this.biais = biais;

        this.finalWeight = finalWeight;
        this.finalBiais = finalBiais;

        this.width = biais.length;
        this.height = biais[0].length;
    }

    /**
     * To clone a brain.
     *
     * @param brain old brain
     */
    public Brain(Brain brain){
        this(brain.getWeights(), brain.getBiais(),
                brain.getFinalWeight(), brain.getFinalBiais());
    }

    /**
     * To get a copy of the weights.
     *
     * @return a copy of the weights.
     */
    public double[][][] getWeights(){
        return Math2.clone(weight);
    }

    /**
     * To get a copy of the biais.
     *
     * @return a copy of the biais.
     */
    public double[][] getBiais(){
        return Math2.clone(biais);
    }

    public double[][] getFinalWeight() {
        return Math2.clone(finalWeight);
    }

    public double[] getFinalBiais() {
        return Math2.clone(finalBiais);
    }

    /**
     * Transmit the information from the input to the output.
     *
     * @param information information like vision or else.
     */
    private double transmitInformation(double[] information){
        if(information.length != height)
            throw new IllegalArgumentException();

        double[][] value = new double[2][height];
        // Set the first column of the matrice.
        value[0] = information;

        // Transmit the data to the next column
        for (int i = 0; i < width; i++) {
            transmitCol(i, value[i%2], value[(i+1)%2]);
        }

        return transmitLastColumn(value[width%2]);
    }
    
    /**
     * Transmit the data from one column to the next one
     * @param fromCol start column.
     */
    private void transmitCol(int fromCol, double[] fromColumn, double[] toColumn){
        if(!(fromColumn.length == toColumn.length &&
            fromColumn.length == height &&
            0 <= fromCol && fromCol < width))
                    throw new IllegalArgumentException();
        
        for (int i = 0; i < height; i++) {
            double actualBiais = biais[fromCol][i];
            double z = calculZ(weight[fromCol], fromColumn, i, actualBiais);
            System.out.println("z " + z);
            toColumn[i] = z;
        }
        
    }

    private double calculZ(double[][] weightColumn, double[] value, int fromCol, double biais) {
        double nextValue = 0;
        for (int i = 0; i < height; i++) {
            double a = value[i];
            double b = weightColumn[i][fromCol];
            System.out.println("a*b " + a + " " + b);
            nextValue += a * b;
        }

        System.out.println("nextValue " + nextValue);
        nextValue+= biais;
        System.out.println("biais " + biais);
        return 1 / (1 + Math.exp(-nextValue));
    }


    private double transmitLastColumn(double[] lastColumn){
        double nextValue = 0;
        for (int i = 0; i < lastColumn.length; i++) {
            System.out.println("final a*b " + lastColumn[i] + " " + finalWeight[0][i]);
            nextValue += lastColumn[i] * finalWeight[0][i];
        }
        System.out.println("finalBiais " + finalBiais[0]);
        nextValue += finalBiais[0];
        return 1 / (1+ Math.exp(-nextValue));
    }

    public double testBrain(double[] information){
        return transmitInformation(information);
    }
}
