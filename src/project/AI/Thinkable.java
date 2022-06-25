package project.AI;

import project.life.Action;

public interface Thinkable {
    Action nextAction(Double[] information);
}
