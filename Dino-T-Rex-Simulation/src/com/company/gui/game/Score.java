package com.company.gui.game;

import com.company.gui.utils.Style;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Score {
    protected Pane root;
    protected Text score;
    private int counter = 0;

    Score(Pane pane) {
        this.root = pane;
        this.init();
        this.time();
    }

    private void init() {
        this.score = new Text(770, 30, "Score: 00000");
        this.score.setStyle(Style.getSmallText());
        root.getChildren().add(this.score);
    }

    private void time() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(100), t1 -> {
                    counter++;
                    score.setText("Score: " + String.format("%05d", counter));
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
