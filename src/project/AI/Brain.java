package project.AI;

import project.life.Action;

public final class Brain implements Thinkable {

    private final BrainPart brainPartVertical;
    private final BrainPart brainPartHorizontal;

    /**
     * Provide an action
     *
     * @param information information to treat like view on food or wall.
     * @return future action.
     */
    @Override
    public Action nextAction(double[] information) {
        double vertical = brainPartVertical.testBrain(information);
        double horizontal = brainPartHorizontal.testBrain(information);

        if(Math.abs(horizontal - 0.5) >= Math.abs(vertical - 0.5)){
            // Horizontale
            return horizontal >= 0.5 ? Action.MOVE_RIGHT : Action.MOVE_LEFT;
        }else {
            // Vertical
            return vertical >= 0.5 ? Action.MOVE_UP : Action.MOVE_DOWN;
        }
    }

    /**
     * To create a brain of a certain height and width.
     *
     * @param height number of information given.
     * @param width width of the machine learning.
     */
    public Brain (int height, int width){
        this(new BrainPart(height, width), new BrainPart(height, width));
    }


    /**
     * To create a brain.
     *
     * @param brainPartHorizontal horizontal brain part.
     * @param brainPartVertical vertical brain part.
     */
    private Brain(BrainPart brainPartHorizontal, BrainPart brainPartVertical){

        this.brainPartHorizontal = brainPartHorizontal;
        this.brainPartVertical = brainPartVertical;
    }

    /**
     * To clone a brain.
     *
     * @param brain old brain
     */
    public Brain(Brain brain){
        this(brain.getPartBrainHorizontal(), brain.getPartBrainVertical());
    }


    public void evolve(double speed){
        this.brainPartHorizontal.evolve(speed);
        this.brainPartVertical.evolve(speed);
    }

    private BrainPart getPartBrainHorizontal(){
        return new BrainPart(brainPartHorizontal);
    }

    private BrainPart getPartBrainVertical(){
        return new BrainPart(brainPartVertical);
    }


}
