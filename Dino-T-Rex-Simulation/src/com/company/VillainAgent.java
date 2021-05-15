package com.company;

import jade.core.AID;
import jade.core.Agent;
import jade.core.ServiceException;
import jade.core.behaviours.TickerBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.lang.acl.ACLMessage;

import static java.lang.Math.random;

public class VillainAgent extends Agent {
    protected void setup() {
        try {
            TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
            final AID topic = topicHelper.createTopic("GAME");

            addBehaviour(new TickerBehaviour(this, 5000) {
                public void onTick() {
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    double prob = random();
                    Action nextObstacle = prob < 0.5
                            ? Action.SEND_BIRD
                            : Action.SEND_CACTUS;
                    System.out.println("Sending " + nextObstacle.name());
                    msg.setContent(nextObstacle.name());
                    msg.setOntology("dino");
                    msg.addReceiver(topic);
                    myAgent.send(msg);
                }
            });
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public void terminate() {
        doDelete();
    }
}
