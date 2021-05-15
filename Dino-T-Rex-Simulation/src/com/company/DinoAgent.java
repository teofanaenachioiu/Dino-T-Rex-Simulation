package com.company;

import jade.core.AID;
import jade.core.Agent;
import jade.core.ServiceException;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Timer;
import java.util.TimerTask;

public class DinoAgent extends Agent {
    protected void setup() {
        try {
            TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
            final AID topic = topicHelper.createTopic("GAME");
            topicHelper.register(topic);

            addBehaviour(new CyclicBehaviour(this) {
                public void action() {
                    ACLMessage msg = myAgent.receive(MessageTemplate.MatchTopic(topic));

                    if (msg != null && msg.getOntology() != null) {
                        System.out.println("Received " + msg.getContent() +
                                " with ontology " + msg.getOntology() +
                                " from agent " + msg.getSender().getName());

                        ACLMessage reply = new ACLMessage(ACLMessage.INFORM);
                        reply.addReceiver(topic);
                        if (msg.getContent().equals(Action.SEND_CACTUS.name())) {
                            reply.setContent(Action.JUMP.name());
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    send(reply);
                                }
                            }, 8500);
                        } else if (msg.getContent().equals(Action.SEND_BIRD.name())) {
                            reply.setContent(Action.SQUAT.name());
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    send(reply);
                                }
                            }, 6000);
                        }
                    }
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
