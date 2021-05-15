package com.company;

import com.company.gui.Main;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ServiceException;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.messaging.TopicManagementHelper;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class GuiAgent extends Agent {
    private Long lastMessageReceivingTime = System.currentTimeMillis();
    private Main gui = new Main();

    @Override
    protected void setup() {
        try {
            launchGUI();

            TopicManagementHelper topicHelper = (TopicManagementHelper) getHelper(TopicManagementHelper.SERVICE_NAME);
            final AID topic = topicHelper.createTopic("GAME");
            topicHelper.register(topic);

            addBehaviour(new CyclicBehaviour(this) {
                public void action() {
                    ACLMessage msg = myAgent.receive(MessageTemplate.MatchTopic(topic));
                    if (msg != null) {
                        Long receivingTime = msg.getPostTimeStamp();
                        System.out.println("Received " + msg.getContent() +
                                " from agent " + msg.getSender().getName() +
                                " at " + receivingTime);
                        if (msg.getContent().equals(Action.JUMP.name())
                                || msg.getContent().equals(Action.SQUAT.name())) {
                            if (receivingTime - lastMessageReceivingTime < 1000) {
                                gui.updateGui(Action.DIE);
                            } else {
                                lastMessageReceivingTime = receivingTime;
                                gui.updateGui(Action.valueOf(msg.getContent()));
                            }
                        } else {
                            gui.updateGui(Action.valueOf(msg.getContent()));
                        }
                    }
                }
            });
        } catch (
                ServiceException e) {
            e.printStackTrace();
        }
    }

    public void terminate() {
        doDelete();
    }

    private void launchGUI() {
        new Thread(() -> gui.launch()).start();
    }
}
