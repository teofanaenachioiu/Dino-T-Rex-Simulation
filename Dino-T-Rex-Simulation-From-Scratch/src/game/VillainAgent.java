package game;

import agent.Action;
import agent.Agent;
import agent.Percept;

public class VillainAgent extends Agent {
    private Obstacle obstacle;

    @Override
    public void see(Percept p) {
        obstacle = Math.random() < 0.5
                ? Obstacle.BIRD
                : Obstacle.CACTUS;
    }

    @Override
    public Action selectAction() {
        return obstacle.equals(Obstacle.BIRD)
                ? new SendBird()
                : obstacle.equals(Obstacle.CACTUS)
                ? new SendCactus()
                : null;
    }

    @Override
    public String toString() {
        return "Villain";
    }
}
