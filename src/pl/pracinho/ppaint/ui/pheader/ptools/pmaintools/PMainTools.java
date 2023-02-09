package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.POtherTools;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.PPencil;
import pl.pracinho.ppaint.utils.SpringUtilities;

import javax.swing.*;

public class PMainTools extends JPanel {

    private PPencil pPencil;
    private POtherTools pOtherTools;

    public PMainTools() {
        initComponents();
        initView();
    }

    private void initView() {
        this.setLayout(new SpringLayout());
        this.add(pPencil);
        this.add(new JSeparator(SwingConstants.VERTICAL));
        this.add(pOtherTools);

        SpringUtilities.makeCompactGrid(this,
                1, this.getComponentCount(),
                5, 5,
                5, 5);
    }

    private void initComponents() {
        pPencil = new PPencil();
        pOtherTools = new POtherTools();
    }
}