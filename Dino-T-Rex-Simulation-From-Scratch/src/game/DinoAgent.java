package game;

import agent.Action;
import agent.Agent;
import agent.Percept;

public class DinoAgent extends Agent {
    private Obstacle obstacle;
    private Long previousTime = System.currentTimeMillis();

    @Override
    public void see(Percept p) {
        obstacle = ((GamePercept) p).getObstacle();
    }

    @Override
    public Action selectAction() {
        long time = System.currentTimeMillis();
        if ((time - previousTime) < 1000) {
            return new Die();
        } else {
            previousTime = time;
        }
        return obstacle.equals(Obstacle.BIRD)
                ? new Squat()
                : obstacle.equals(Obstacle.CACTUS)
                ? new Jump()
                : null;
    }

    @Override
    public String toString() {
        return "Dinosaur";
    }
}
