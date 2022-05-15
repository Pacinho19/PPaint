package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pcolors.model;

import java.awt.*;

public enum PColor {

    BLACK(Color.BLACK),
    WHITE(Color.WHITE),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    RED(Color.RED);

    private Color color;

    PColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}