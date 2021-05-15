package com.company.gui.window;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Window implements IWindow {
    public Pane pane;

    /**
     * Generic class to create the scenes
     *
     * @param pane
     */
    public Window(Pane pane) {
        this.pane = pane;
    }

    public Scene create() {
        return new Scene(this.pane, 1000, 600); }
}
