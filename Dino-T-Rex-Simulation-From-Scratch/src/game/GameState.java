package game;

import agent.State;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GameState extends State {
    private final BlockingQueue<Obstacle> obstacles = new ArrayBlockingQueue<>(20);
    private int numOfObstacles;
    private boolean isGameOver = false;

    public static GameState getInitState(int number) {
        GameState state = new GameState();
        state.numOfObstacles = number;
        return state;
    }

    @Override
    public void display() {
        System.out.println("game state");
    }

    public synchronized int getNumOfObstacles() {
        return numOfObstacles;
    }

    public Obstacle getObstacle() {
        try {
            return obstacles.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized void decrementObstacles() {
        numOfObstacles--;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
        decrementObstacles();
    }

    public synchronized int getNumObstaclesInQueue() {
        return obstacles.size();
    }

    public boolean isGameInterrupt() {
        return isGameOver;
    }

    public void setGameOver() {
        isGameOver = true;
    }
}
