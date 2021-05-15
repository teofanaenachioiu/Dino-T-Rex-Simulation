package game;

import agent.Action;
import agent.Agent;
import agent.State;

public class Jump extends Action {
    @Override
    public State execute(Agent a, State s) {
        if (s instanceof GameState) {
            return s;
        } else {
            System.out.println("ERROR - Argument is not of type GameState");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Jump";
    }
}
