package pl.pracinho.ppaint.ui.pcanvas;

import pl.pracinho.ppaint.ui.pcanvas.tools.PFunction;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pmaintools.pcolorfiller.PColorFiller;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.PColors;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.PShapes;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.PSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class PCanvas extends JPanel {

    public static PCanvas pCanvas;
    public static PFunction pFunction;

    public PCanvas() {
        this.setBackground(Color.WHITE);
        pCanvas = this;
        pFunction = PFunction.DRAW;
        initActions();
    }

    private void initActions() {
        this.addMouseMotionListener(mouseDraggedAdapter());
        //this.addMouseListener(mouseClickAdapter());
    }

    private MouseListener mouseClickAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PColorFiller.fill(e.getX(), e.getY());
            }
        };
    }

    private MouseMotionListener mouseDraggedAdapter() {
        return new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                doDrawing(e);
            }
        };
    }

    private void doDrawing(MouseEvent e) {
        if (pFunction == PFunction.FILL) {
            PColorFiller.fill(e.getX(), e.getY());
            return;
        }

        Graphics g = getGraphics();

        if (isLeftMouseButton(e)) g.setColor(PColors.selectedColor);
        else g.setColor(this.getBackground());

        draw(g, e);
    }

    private void draw(Graphics g, MouseEvent e) {
        try {
            Method method = Graphics.class.getDeclaredMethod(PShapes.selectedShape.getPPaintMethod().getName(), int.class, int.class, int.class, int.class);
            method.invoke(g, e.getX(), e.getY(), PSize.SIZE, PSize.SIZE);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }


    public void drawRect(int x, int y, int width, int height) {
        Graphics g = getGraphics();
        g.setColor(PColors.selectedColor);
        g.fillRect(x, y, width, height);
    }
}