package com.company.gui.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Dino {
    private Pane root;
    private ImageView dinoView;
    private boolean jumping = true;
    private Timeline running;

    Dino(Pane pane) {
        this.root = pane;
        this.init();
    }

    private void init() {
        dinoView = new ImageView(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-left-up.png"));
        dinoView.setLayoutY(420);
        dinoView.setLayoutX(50);
        this.root.getChildren().add(dinoView);
    }

    public void startRunning() {
        running = new Timeline(
                new KeyFrame(Duration.millis(200), t1 -> dinoView.setImage(
                        new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-left-up.png"))),
                new KeyFrame(Duration.millis(400), t12 -> dinoView.setImage(
                        new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-right-up.png")))
        );
        running.setCycleCount(Timeline.INDEFINITE);
        running.play();
    }

    public void animationJump() {
        jumping = true;
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(50), t1 -> {
                    if (jumping) {
                        if (dinoView.getLayoutY() < 300) {
                            jumping = false;
                            dinoView.setLayoutY(dinoView.getLayoutY() + 5);
                        } else {
                            dinoView.setLayoutY(dinoView.getLayoutY() - 5);
                        }
                    } else {
                        dinoView.setLayoutY(dinoView.getLayoutY() + 5);
                    }
                })
        );
        t.setCycleCount(50);
        t.setOnFinished(event -> dinoView.setLayoutY(420));
        t.play();
    }

    public void animationSquat() {
        running.stop();
        dinoView.setLayoutY(440);
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(200), t1 -> dinoView.setImage(
                        new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-below-left-up.png"))),
                new KeyFrame(Duration.millis(400), t12 -> dinoView.setImage(
                        new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-below-right-up.png")))
        );
        t.setCycleCount(5);
        t.setOnFinished((event) -> {
            running.play();
            dinoView.setLayoutY(420);
        });
        t.play();
    }
}
