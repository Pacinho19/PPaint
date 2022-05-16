package pl.pracinho.ppaint.ui.pheader.pfile;

import pl.pracinho.ppaint.ui.pcanvas.PCanvas;
import pl.pracinho.ppaint.ui.pheader.pfile.controller.PFileController;

import javax.swing.*;

public class PFile extends JMenu {

    private JMenuItem exit;
    private JMenuItem save;
    private JMenuItem load;

    private PFileController pFileController;

    public PFile( ) {
        pFileController = new PFileController(this);
        this.setText("File");
        initComponent();
        initView();
        initActions();
    }

    private void initActions() {
        exit.addActionListener(e -> System.exit(0));
        save.addActionListener(e -> pFileController.save());
        save.addActionListener(e -> pFileController.load());
    }

    private void initView() {
        this.add(load);
        this.add(save);
        this.add(exit);
    }

    private void initComponent() {
        exit = new JMenuItem("Exit");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
    }

}