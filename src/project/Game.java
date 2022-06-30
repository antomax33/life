package project;

import project.GUI.Draw;
import javafx.scene.layout.Pane;


public abstract class Game {

    public abstract boolean step();
    public abstract Pane pane();
}
