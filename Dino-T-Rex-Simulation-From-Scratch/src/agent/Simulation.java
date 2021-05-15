package agent;

import java.util.List;

/**
 * The top-level class for an agent simulation. This can be used for either
 * single or multi-agent simulations.
 */
public abstract class Simulation {

    protected List<Agent> agents;
    protected Environment env;

    /**
     * Constructs a new simulation. Initializes the agent(or agents vector) and
     * the environment.
     */
    public Simulation(Environment e, List<Agent> a) {
        agents = a;
        env = e;

    }

    /**
     * Runs the simulation starting from a given state. This consists of a
     * sense-act loop for the/(each) agent. An alternative approach would be to
     * allow the agent to decide when it will sense and act.
     */
    public abstract void start(State initState);

    /**
     * Is the simulation over? Returns true if it is, otherwise false.
     */
    protected abstract boolean isComplete(Agent agent);
}
