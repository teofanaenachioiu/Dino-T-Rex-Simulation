package com.company.gui.menu;

import com.company.gui.game.Game;
import com.company.gui.utils.Style;
import com.company.gui.window.Window;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuGameOver {
    public Stage primaryStage;
    private Pane pane;
    private Game game;

    public MenuGameOver(Game game, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.game = game;
        this.init();
    }

    public void start() {
        primaryStage.setScene(new Window(this.pane).create());
        primaryStage.centerOnScreen();
    }

    private Label label() {
        Label label = new Label();
        label.setText("Game Over");
        label.setStyle(Style.getBigText());
        label.setLayoutX(350);
        label.setLayoutY(50);
        return label;
    }

    private Button startBtn() {
        ImageView retryIm = new ImageView(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Game_restart.png"));
        Button retry = new Button("Retry", retryIm);
        retry.setLayoutY(200);
        retry.setLayoutX(400);
        retry.setStyle(Style.getButton() + Style.getSmallText());
        retry.setOnAction(event -> game.start());
        return retry;
    }

    private void init() {
        pane = new Pane();
        pane.setStyle(Style.getBackground());
        pane.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
        pane.getChildren().add(this.label());
        pane.getChildren().add(this.startBtn());
    }
}
