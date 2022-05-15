package pl.pracinho.ppaint.ui.pheader.pfile;

import pl.pracinho.ppaint.ui.pcanvas.PCanvas;
import pl.pracinho.ppaint.ui.pheader.pfile.controller.PFileController;

import javax.swing.*;

public class PFile extends JMenu {

    private JMenuItem exit;
    private JMenuItem save;

    private PCanvas pCanvas;
    private PFileController pFileController;

    public PFile(PCanvas pCanvas) {
        pFileController = new PFileController(this);
        this.pCanvas = pCanvas;
        this.setText("File");
        initComponent();
        initView();
        initActions();
    }

    private void initActions() {
        exit.addActionListener(e -> System.exit(0));
        save.addActionListener(e -> pFileController.save());
    }

    private void initView() {
        this.add(exit);
        this.add(save);
    }

    private void initComponent() {
        exit = new JMenuItem("Exit");
        save = new JMenuItem("Save");
    }

    public PCanvas getPCanvas() {
        return pCanvas;
    }
}