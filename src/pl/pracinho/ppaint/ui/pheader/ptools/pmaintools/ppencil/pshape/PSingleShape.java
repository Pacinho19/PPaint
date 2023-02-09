package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.model.PShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.PShapes.pSingleShapes;

public class PSingleShape extends JRadioButton {

    public boolean selected;

    private PShape pShape;

    public PSingleShape(PShape pShape, boolean selected) {
        this.pShape = pShape;
        this.selected = selected;

        this.setPreferredSize(new Dimension(50, 50));
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);

        initActions();
    }

    private void initActions() {
        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                selected = true;
                pSingleShapes.forEach(ps -> {
                    if (ps != PSingleShape.this) ps.selected = false;
                });
                repaint();
                PShapes.selectedShape = pShape;
            }
        };

        addMouseListener(mouseListener);

    }

    private int getDiameter() {
        return Math.min(getWidth(), getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {

        int diameter = getDiameter();
        int radius = diameter / 2;

        g.setColor(pShape.getPShapeColor().getBackColor());

        if (pShape == PShape.OVAL || pShape == PShape.OVAL_FILL)
            g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
        else if (pShape == PShape.RECTANGLE || pShape == PShape.RECTANGLE_FILL)
            g.fillRect(2, 2, (int) (diameter * 0.9), (int) (diameter * 0.9));

        if (selected) setBorder(g);
    }

    private void setBorder(Graphics g) {

        int diameter = getDiameter();
        int radius = diameter / 2;

        g.setColor(Color.RED);
        if (pShape == PShape.OVAL || pShape == PShape.OVAL_FILL)
            g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, diameter, diameter);
        else if (pShape == PShape.RECTANGLE || pShape == PShape.RECTANGLE_FILL)
            g.drawRect(2, 2,  (int) (diameter * 0.9), (int) (diameter * 0.9));
    }

    public PShape getPShape() {
        return pShape;
    }
}
