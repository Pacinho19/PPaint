package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pmaintools.pcolorfiller;

import pl.pracinho.ppaint.ui.pcanvas.PCanvas;
import pl.pracinho.ppaint.ui.pcanvas.tools.PFunction;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pmaintools.pcolorfiller.model.NeighborPosition;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PColorFiller extends JButton {

    public PColorFiller() {
        this.setText("Fill");
        initActions();
    }

    private void initActions() {
        this.addActionListener(e -> {
            PCanvas.pFunction = PFunction.FILL;
            PCanvas.pCanvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        });
    }

    public static void fill(int x, int y) {

        Color baseColor = getClickedColor(x, y);
        if (baseColor == null) return;

        int maxX = PCanvas.pCanvas.getWidth();
        int maxY = PCanvas.pCanvas.getHeight();

        Set<String> checked = new HashSet<>();
        checkNeighbors(checked, baseColor, x, y, maxX, maxY);

        PCanvas.pFunction = PFunction.DRAW;
        PCanvas.pCanvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }


    private static void checkNeighbors(Set<String> checked, Color baseColor, int x, int y, int maxX, int maxY) {

        checkFill(baseColor, x, y);
        checked.add(getStringPosition(x, y));

        List.of(NeighborPosition.values())
                .forEach(np -> {
                    int x1 = x + np.getChangeX();
                    int y1 = y + np.getChangeY();

                    if (checked.contains(getStringPosition(x1, y1))) return;
                    checked.add(getStringPosition(x, y));

                    if (checkPosition(x1, y1, maxX, maxY)) {
                        if (checkFill(baseColor, x1, y1)) checkNeighbors(checked, baseColor, x1, y1, maxX, maxY);
                    }
                });

    }

    private static String getStringPosition(int x, int y) {
        return x + "," + y;
    }

    private static boolean checkPosition(int x1, int y1, int maxX, int maxY) {
        if (x1 < 0) return false;
        if (x1 > maxX) return false;
        if (y1 < 0) return false;

        return y1 <= maxY;
    }

    private static boolean checkFill(Color baseColor, int x, int y) {
        if (Objects.equals(baseColor, getClickedColor(x, y))) {
            PCanvas.pCanvas.drawRect(x, y, 1, 1);
            return true;
        }
        return false;
    }

    private static Color getClickedColor(int x, int y) {
        try {
            Robot r = new Robot();
            return r.getPixelColor(x, y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }
}
