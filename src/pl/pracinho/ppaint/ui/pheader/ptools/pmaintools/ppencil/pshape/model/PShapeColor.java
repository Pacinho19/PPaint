package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.model;

import java.awt.*;

public enum PShapeColor {

    FILL(Color.BLACK, Color.GRAY),
    NO_FILL(Color.WHITE, Color.GRAY),;


    PShapeColor(Color backColor, Color pressedColor) {
        this.backColor = backColor;
        this.pressedColor = pressedColor;
    }

    private Color backColor;
    private Color pressedColor;

    public Color getBackColor() {
        return backColor;
    }

    public Color getPressedColor() {
        return pressedColor;
    }
}
