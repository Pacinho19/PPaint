package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.utils;

import java.awt.*;

public class ColorUtils {

    public static Color getClickedColor() {
        try {
            Point location = MouseInfo.getPointerInfo().getLocation();
            return new Robot().getPixelColor(location.x, location.y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }
}
