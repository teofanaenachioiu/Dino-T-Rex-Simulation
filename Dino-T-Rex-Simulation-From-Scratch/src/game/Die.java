package game;

import agent.Action;
import agent.Agent;
import agent.State;

public class Die extends Action {
    @Override
    public State execute(Agent a, State s) {
        GameState state;
        if (s instanceof GameState) {
            state = (GameState) s;
            state.setGameOver();
            return state;
        } else {
            System.out.println("ERROR - Argument is not of type GameState");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Die";
    }
}
