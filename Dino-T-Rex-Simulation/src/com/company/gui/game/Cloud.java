package com.company.gui.game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Cloud {
    private Pane root;
    private Image cloudMiniImg = new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Cloud.png");
    private Image cloudBigImg = new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Cloud-min.png");
    private ImageView cloudImageViewOne = new ImageView(this.cloudMiniImg);
    private ImageView cloudImageViewTwo = new ImageView(this.cloudMiniImg);
    private ImageView cloudImageViewTree = new ImageView(this.cloudBigImg);
    private ImageView cloudImageViewFour = new ImageView(this.cloudMiniImg);
    private ImageView cloudImageVieFive = new ImageView(this.cloudBigImg);
    private ImageView cloudImageVieSix = new ImageView(this.cloudMiniImg);

    public Cloud(Pane pane) {
        this.root = pane;
        this.init();
    }

    private void init() {
        this.setImageLayoutXY();
        this.setAnimation();
        this.setImage();
    }

    private void setImageLayoutXY() {
        cloudImageViewOne.setLayoutX(700);
        cloudImageViewOne.setLayoutY(200);
        cloudImageViewTwo.setLayoutX(1400);
        cloudImageViewTwo.setLayoutY(130);
        cloudImageViewTree.setLayoutX(1000);
        cloudImageViewTree.setLayoutY(160);
        cloudImageViewFour.setLayoutX(2200);
        cloudImageViewFour.setLayoutY(200);
        cloudImageVieFive.setLayoutX(2500);
        cloudImageVieFive.setLayoutY(160);
        cloudImageVieSix.setLayoutX(3000);
        cloudImageVieSix.setLayoutY(130);
    }

    private void setImage() {
        root.getChildren().add(cloudImageViewOne);
        root.getChildren().add(cloudImageViewTwo);
        root.getChildren().add(cloudImageViewTree);
        root.getChildren().add(cloudImageViewFour);
        root.getChildren().add(cloudImageVieFive);
        root.getChildren().add(cloudImageVieSix);
    }

    private void setAnimation() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewOne.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewTwo.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewTree.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageViewFour.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageVieFive.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(10), new KeyValue(cloudImageVieSix.translateXProperty(), -1500))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
