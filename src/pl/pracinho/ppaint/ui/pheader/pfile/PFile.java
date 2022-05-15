package pl.pracinho.ppaint.ui.pheader.pfile;

import javax.swing.*;

public class PFile extends JMenu {

    private JMenuItem exit;

    public PFile() {
        this.setText("File");
        initComponent();
        initView();
        initActions();
    }

    private void initActions() {
        exit.addActionListener(e -> System.exit(0));
    }

    private void initView() {
        this.add(exit);
    }

    private void initComponent() {
        exit = new JMenuItem("Exit");
    }
}