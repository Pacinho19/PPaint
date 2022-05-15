package pl.pracinho.ppaint.ui.pheader.ptools;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.PMainTools;
import pl.pracinho.ppaint.ui.pheader.ptools.pview.PView;

import javax.swing.*;

public class PTools extends JTabbedPane {

    private PMainTools pMainTools;
    private PView pView;

    public PTools() {
        initComponents();
        initView();
    }

    private void initView() {
        this.add("Main Tools", pMainTools);
        this.add("View", pView);
    }

    private void initComponents() {
        pMainTools = new PMainTools();
        pView = new PView();
    }


}