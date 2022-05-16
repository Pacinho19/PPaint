package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pmaintools;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pmaintools.pcolorfiller.PColorFiller;

import javax.swing.*;

public class POtherTools extends JPanel {

    private PColorFiller pColorFiller;

    public POtherTools() {
        initComponent();
        initView();
    }

    private void initView() {
        this.add(pColorFiller);
    }

    private void initComponent() {
        pColorFiller = new PColorFiller();
        pColorFiller.setEnabled(false);
    }
}
