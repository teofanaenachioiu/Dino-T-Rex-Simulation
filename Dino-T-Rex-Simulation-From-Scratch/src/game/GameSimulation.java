package game;

import agent.*;

import java.util.List;

public class GameSimulation extends Simulation {
    public GameSimulation(GameEnvironment env, List<Agent> a) {
        super(env, a);
    }

    @Override
    public void start(State initState) {
        System.out.println("START of simulation");
        System.out.println();

        env.setInitialState(initState);

        Thread threadAgent1 = new Thread(() -> {
            VillainAgent agent = (VillainAgent) agents.get(0);
            while (isComplete(agent)) {
                Percept p = env.getPercept(agent);
                agent.see(p);
                Action action = agent.selectAction();
                env.updateState(agent, action);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadAgent2 = new Thread(() -> {
            DinoAgent agent = (DinoAgent) agents.get(1);
            while (isComplete(agent)) {
                Percept p = env.getPercept(agent);
                agent.see(p);
                Action action = agent.selectAction();
                env.updateState(agent, action);
            }
        });

        threadAgent1.start();
        threadAgent2.start();

        try {
            threadAgent1.join();
            threadAgent2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (((GameState) env.currentState()).isGameInterrupt()) {
            System.out.println("GAME OVER!");
        } else {
            System.out.println("END of simulation");
        }
    }

    @Override
    protected boolean isComplete(Agent agent) {
        return !((GameState) env.currentState()).isGameInterrupt() && (agent instanceof VillainAgent
                ? (((GameState) env.currentState()).getNumOfObstacles() != 0)
                : (((GameState) env.currentState()).getNumOfObstacles() != 0
                || ((GameState) env.currentState()).getNumObstaclesInQueue() != 0));
    }

    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("*   ”T-Rex Dino Chrome” Game   *");
        System.out.println("********************************");
        System.out.println();

        VillainAgent villainAgent = new VillainAgent();
        DinoAgent dinoAgent = new DinoAgent();
        GameEnvironment env = new GameEnvironment();
        GameSimulation sim = new GameSimulation(env, List.of(villainAgent, dinoAgent));
        GameState initState = GameState.getInitState(20);

        sim.start(initState);
    }
}
