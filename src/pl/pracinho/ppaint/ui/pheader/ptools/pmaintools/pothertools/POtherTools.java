package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools;


import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pcolorfiller.PColorFiller;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.ppipete.PPipete;
import pl.pracinho.ppaint.utils.SpringUtilities;

import javax.swing.*;

public class POtherTools extends JPanel {

    private PColorFiller pColorFiller;
    private PPipete pPipete;

    public POtherTools() {
        initComponent();
        initView();
    }

    private void initView() {
        this.setLayout(new SpringLayout());
        this.add(pColorFiller);
        this.add(pPipete);

        SpringUtilities.makeCompactGrid(this,
                this.getComponentCount(), 1,
                5, 5,
                5, 5);
    }

    private void initComponent() {
        pColorFiller = new PColorFiller();
        pColorFiller.setEnabled(false);

        pPipete = new PPipete();
    }
}
