package pl.pracinho.ppaint.ui.pcanvas;

import pl.pracinho.ppaint.ui.pcanvas.tools.PFunction;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pcolorfiller.PColorFiller;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.ppipete.PPipete;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.PColors;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.PShapes;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.PSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class PCanvas extends JPanel {

    public static PCanvas pCanvas;
    public static PFunction pFunction;

    public PCanvas() {
        this.setBackground(Color.WHITE);

        init();
        initActions();
    }

    private void init() {
        pCanvas = this;
        pFunction = PFunction.DRAW;
    }

    private void initActions() {
        this.addMouseMotionListener(mouseDraggedAdapter());
        this.addMouseListener(mouseClickAdapter());
    }

    private MouseListener mouseClickAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                switch (pFunction) {
                    case DRAW -> doDrawing(e);
                    case FILL -> PColorFiller.fill(e.getX(), e.getY());
                    case PIPETE -> PPipete.getColor(e);
                }
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

        if (isLeftMouseButton(e)) g.setColor(PColors.colorOne.getSelectedColor());
        else g.setColor(PColors.colorTwo.getSelectedColor());

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
        g.setColor(PColors.colorOne.getSelectedColor());
        g.fillRect(x, y, width, height);
    }
}