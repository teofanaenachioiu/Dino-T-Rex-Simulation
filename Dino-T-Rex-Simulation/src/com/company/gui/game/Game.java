package com.company.gui.game;

import com.company.Action;
import com.company.gui.menu.MenuGameOver;
import com.company.gui.utils.Style;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.company.gui.window.Window;

public class Game {
    protected Pane root;
    protected Stage primaryStage;
    protected Dino dino;
    public boolean ready = false;
    public boolean thereWasAnObstacle = false;

    public void init(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void start() {
        root = new Pane();
        dino = new Dino(root);
        dino.startRunning();

        new Sun(root);
        new Cloud(root);
        new Score(root);
        new Ground(root);

        root.setStyle(Style.getBackground());
        primaryStage.setScene(new Window(this.root).create());
        primaryStage.centerOnScreen();
        ready = true;
    }

    public void doAction(Action message) {
        System.out.println("[game] " + message);

        if (message.equals(Action.DIE)) {
            this.ready = false;
            this.thereWasAnObstacle = false;
            Platform.runLater(() -> new MenuGameOver(this, primaryStage).start());
        } else if (message.equals(Action.SEND_CACTUS)) {
            Platform.runLater(() -> new Cactus(root));
        } else if (message.equals(Action.SEND_BIRD)) {
            Platform.runLater(() -> new Bird(root));
        } else if (message.equals(Action.JUMP)) {
            Platform.runLater(() -> dino.animationJump());
        } else if (message.equals(Action.SQUAT)) {
            Platform.runLater(() -> dino.animationSquat());
        }
    }
}
