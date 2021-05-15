package game;

import agent.Agent;
import agent.Percept;

public class GamePercept extends Percept {
    private Obstacle obstacle;

    public GamePercept(GameState state, Agent agent) {
        super(state, agent);
        if (agent instanceof DinoAgent) {
            obstacle = state.getObstacle();
        }
    }

    public Obstacle getObstacle() {
        return this.obstacle;
    }

    @Override
    public String toString() {
        return obstacle != null ? obstacle.toString() : "none";
    }
}
