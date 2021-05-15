package com.company.gui.menu;

import com.company.gui.utils.Style;
import com.company.gui.window.Window;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.company.gui.game.Game;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuStart {
    private final Stage primaryStage;
    private final Game game;

    public MenuStart(Stage primaryStage, Game game) {
        this.primaryStage = primaryStage;
        this.game = game;
        this.init();
    }

    private Label label() {
        Label label = new Label();
        label.setText("T. Rex Dinosaur Game");
        label.setStyle(Style.getBigText());
        label.setLayoutY(50);
        label.setLayoutX(250);
        return label;
    }

    private ImageView groundImgView() {
        ImageView groundImgView = new ImageView(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Ground.png"));
        groundImgView.setLayoutY(450);
        return groundImgView;
    }

    private ImageView dinoImgView() {
        ImageView dinoImgView = new ImageView(new Image("file:/home/teofana/IdeaProjects/dino-game/src/com/company/gui/resources/Dino-stand.png"));
        dinoImgView.setLayoutX(50);
        dinoImgView.setLayoutY(420);
        return dinoImgView;
    }

    private Button startBtn() {
        Button startBtn = new Button();
        startBtn.setText("Start Simulation");
        startBtn.setLayoutX(350);
        startBtn.setLayoutY(200);
        startBtn.setStyle("-fx-cursor: hand; -fx-font-family: 'Press Start 2P'; -fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25; -fx-text-fill: #535353; -fx-font-size: 20;");
        startBtn.setOnAction(event -> this.game.start());
        return startBtn;
    }

    private void init() {
        Pane pane = new Pane();
        pane.setStyle(Style.getBackground());
        pane.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
        pane.getChildren().add(this.label());
        pane.getChildren().add(this.startBtn());
        pane.getChildren().add(this.dinoImgView());
        pane.getChildren().add(this.groundImgView());
        this.primaryStage.setScene(new Window(pane).create());
    }
}
