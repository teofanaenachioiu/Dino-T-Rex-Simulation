package com.company.gui.game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Ground {
    private final Pane root;
    private ImageView groundOne;
    private ImageView groundTwo;

    Ground(Pane pane) {
        this.root = pane;
        this.init();
        this.startAnimation();
    }

    private void init() {
        Image groundImg = new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Ground.png");
        groundOne = new ImageView(groundImg);
        groundTwo = new ImageView(groundImg);
        groundOne.setLayoutY(450);
        groundOne.setLayoutX(0);
        groundTwo.setLayoutY(450);
        groundTwo.setLayoutX(1000);
        root.getChildren().add(groundOne);
        root.getChildren().add(groundTwo);
    }

    private void startAnimation() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.seconds(9), new KeyValue(groundOne.translateXProperty(), -1200)),
                new KeyFrame(Duration.seconds(9), new KeyValue(groundTwo.translateXProperty(), -1200))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
