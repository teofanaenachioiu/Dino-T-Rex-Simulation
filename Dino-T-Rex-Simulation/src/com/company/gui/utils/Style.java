package com.company.gui.utils;

public class Style {
    public static String getSmallText() {
        return "-fx-font-family: 'Press Start 2P'; -fx-font-size: 16; -fx-text-fill: #535353;";
    }

    public static String getBigText() {
        return "-fx-font-family: 'Press Start 2P'; -fx-font-size: 25; -fx-text-fill: #535353;";
    }

    public static String getBackground() {
        return "-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);";
    }

    public static String getButton () {
        return "-fx-background-color: transparent; -fx-min-width: 170; -fx-min-height: 25;";
    }
}
