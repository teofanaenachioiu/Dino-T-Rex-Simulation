package com.company.gui.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Bird {
    private Pane root;
    private ImageView imageView;

    Bird(Pane pane) {
        this.root = pane;
        this.init();
        this.startAnimation();
    }

    private void init() {
        this.imageView = new ImageView();
        this.root.getChildren().add(imageView);
    }

    private void startAnimation() {
        this.imageView.setLayoutY(400);
        this.imageView.setLayoutX(1000);
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(200), t1 -> imageView.setImage(
                        new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Bird.png"))),
                new KeyFrame(Duration.millis(400), t2 -> imageView.setImage(
                        new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Bird-1.png"))),
                new KeyFrame(Duration.millis(100), t3 -> {
                    imageView.setLayoutX(imageView.getLayoutX() - 50);
                })
        );
        t.setCycleCount(110);
        t.play();
    }
}
