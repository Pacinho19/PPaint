package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pcolors.PColors;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.PPencil;
import springutilities.SpringUtilities;

import javax.swing.*;

public class PMainTools extends JPanel {

    private PPencil pPencil;

    public PMainTools() {
        initComponents();
        initView();
    }

    private void initView() {
        this.setLayout(new SpringLayout());
        this.add(pPencil);

        SpringUtilities.makeCompactGrid(this,
                1, this.getComponentCount(),
                5, 5,
                5, 5);
    }

    private void initComponents() {
        pPencil = new PPencil();
    }
}