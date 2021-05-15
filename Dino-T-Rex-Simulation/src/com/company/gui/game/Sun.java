package com.company.gui.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sun {
    private final Pane root;

    Sun(Pane pane) {
        this.root = pane;
        this.init();
    }

    protected void init() {
        ImageView imageView = new ImageView(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Sun.png"));
        imageView.setLayoutY(50);
        imageView.setLayoutX(50);
        root.getChildren().add(imageView);
    }
}
