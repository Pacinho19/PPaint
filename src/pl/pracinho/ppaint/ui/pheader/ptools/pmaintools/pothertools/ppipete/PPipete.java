package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.ppipete;

import pl.pracinho.ppaint.ui.pcanvas.PCanvas;
import pl.pracinho.ppaint.ui.pcanvas.tools.PFunction;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.PColors;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class PPipete extends JButton {


    public PPipete() {
        this.setText("Pipete");
        initActions();
    }

    private void initActions() {
        this.addActionListener(e -> {
            PCanvas.pFunction = PFunction.PIPETE;
            PCanvas.pCanvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        });
    }


    public static void getColor(MouseEvent e) {
        PColors.setColorByClick(e, ColorUtils.getClickedColor());
        PCanvas.pCanvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        PCanvas.pFunction = PFunction.DRAW;
    }


}
