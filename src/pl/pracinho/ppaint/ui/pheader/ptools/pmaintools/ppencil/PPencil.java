package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pcolors.PColors;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.PShape;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.PSize;
import springutilities.SpringUtilities;

import javax.swing.*;

public class PPencil extends JPanel {

    private PColors pColors;
    private PSize pSize;
    private PShape pShape;

    public PPencil() {
        init();
        initComponents();
        initView();
    }

    private void init() {
        this.setBorder(BorderFactory.createTitledBorder("Pencil"));
    }

    private void initView() {
        this.setLayout(new SpringLayout());
        this.add(pColors);
        this.add(pSize);
        this.add(pShape);

        SpringUtilities.makeCompactGrid(this,
                1, 3,
                5, 5,
                5, 5);

    }

    private void initComponents() {
        pColors = new PColors();
        pSize = new PSize();
        pShape = new PShape();
    }
}