package project;

import project.GUI.Draw;
import javafx.scene.layout.Pane;


public abstract class Game {

    protected final int maxStep;
    protected int step = 0;

    protected Game(int maxStep){
        this.maxStep = maxStep;
    }

    public abstract double getScore();

    public boolean step(){
        step++;
        return step <= maxStep;
    }
    public abstract Pane pane();

    public abstract double autoGame();
}
