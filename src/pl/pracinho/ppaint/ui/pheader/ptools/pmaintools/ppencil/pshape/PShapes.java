package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.model.PShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PShapes extends JPanel {

    public static PShape selectedShape;
    public static List<PSingleShape> pSingleShapes = new ArrayList<>();

    public PShapes() {
        init();
        initView();
    }

    private void initView() {
        this.setLayout(new FlowLayout());
        List.of(PShape.values())
                .forEach(ps -> {
                    PSingleShape pSS = new PSingleShape(ps, ps == selectedShape);
                    pSingleShapes.add(pSS);
                    this.add(pSS);
                });
    }

    private void init() {
        this.setBorder(BorderFactory.createTitledBorder("Shape"));
        selectedShape = PShape.OVAL_FILL;
    }
}