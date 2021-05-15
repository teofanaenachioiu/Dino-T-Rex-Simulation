package com.company.gui;

import com.company.Action;
import com.company.gui.game.Game;
import com.company.gui.menu.MenuStart;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static Game game = new Game();

    public void updateGui(Action message) {
        if (game != null && game.ready) {
            if (!game.thereWasAnObstacle &&
                    (message.equals(Action.SEND_BIRD)
                            || message.equals(Action.SEND_CACTUS))) {
                game.thereWasAnObstacle = true;
            }
            if (game.thereWasAnObstacle) {
                game.doAction(message);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("T. Rex Dinosaur Game");
        primaryStage.getIcons().add(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-stand.png"));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        game.init(primaryStage);
        new MenuStart(primaryStage, game);
        primaryStage.show();
    }

    public void launch() {
        Application.launch();
    }
}