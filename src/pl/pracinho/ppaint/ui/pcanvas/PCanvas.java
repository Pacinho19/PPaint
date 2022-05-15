package pl.pracinho.ppaint.ui.pcanvas;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pcolors.PColors;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.PSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class PCanvas extends JPanel implements MouseMotionListener {


    public PCanvas() {
        this.addMouseMotionListener(this);
    }


    private void doDrawing(MouseEvent e) {
        Graphics g = getGraphics();
        if (isLeftMouseButton(e)) g.setColor(PColors.selectedColor);
        else g.setColor(this.getBackground());

        g.fillOval(e.getX(), e.getY(), PSize.SIZE, PSize.SIZE);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        doDrawing(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}