package project;

import project.GUI.Draw;
import javafx.scene.layout.Pane;


public abstract class Game implements Draw {

    public abstract void step();
    public abstract Pane pane();
}
