package com.company.gui.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.concurrent.ThreadLocalRandom;

public class Cactus {
    private Pane root;
    private ImageView imageView;

    Cactus(Pane pane) {
        this.root = pane;
        this.init();
        this.startAnimation();
    }

    private void init() {
        int random = ThreadLocalRandom.current().nextInt(1, 6);
        imageView = new ImageView();
        imageView.setImage(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Cactus-" + random + ".png"));
        this.root.getChildren().add(imageView);
    }

    private void startAnimation() {
        imageView.setLayoutY(420);
        imageView.setLayoutX(1000);
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(100), t1 -> {
                    imageView.setLayoutX(imageView.getLayoutX() - 10);
                }));
        t.setCycleCount(110);
        t.play();
    }
}
