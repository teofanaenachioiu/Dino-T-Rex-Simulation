package game;

import agent.Action;
import agent.Agent;
import agent.Environment;
import agent.Percept;

public class GameEnvironment extends Environment {
    @Override
    public Percept getPercept(Agent a) {
        GamePercept percept;
        if (state instanceof GameState) {
            percept = new GamePercept((GameState) state, a);
            try {
                if (a instanceof DinoAgent) {
                    if (percept.getObstacle().equals(Obstacle.BIRD)) {
                        Thread.sleep(1000 + (int) (Math.random() * (1500 + 1)));
                    } else {
                        Thread.sleep(2500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + a.toString() + "] Percept: " + percept.toString());
            return percept;
        } else {
            System.out.println("ERROR - state is not a valid object.");
            return null;
        }
    }

    public void updateState(Agent a, Action action) {
        super.updateState(a, action);
        System.out.println("[" + a.toString() + "] Action: " + action.toString());
        System.out.println();
    }
}
