package pl.pracinho.ppaint.ui.pheader;

import pl.pracinho.ppaint.ui.pcanvas.PCanvas;
import pl.pracinho.ppaint.ui.pheader.pfile.PFile;
import pl.pracinho.ppaint.ui.pheader.ptools.PTools;

import javax.swing.*;

public class PHeader extends JMenuBar {

    private PFile pFile;
    private PTools pTools;

    private PCanvas pCanvas;

    public PHeader(PCanvas pCanvas) {
        this.pCanvas = pCanvas;
        initComponents();
        initView();
    }

    private void initView() {
        this.add("File", pFile);
        this.add(pTools);
    }

    private void initComponents() {
        pFile = new PFile(pCanvas);
        pTools = new PTools();
    }


}