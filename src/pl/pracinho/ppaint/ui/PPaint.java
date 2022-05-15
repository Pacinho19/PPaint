package pl.pracinho.ppaint.ui;

import pl.pracinho.ppaint.config.Properties;
import pl.pracinho.ppaint.ui.pcanvas.PCanvas;
import pl.pracinho.ppaint.ui.pfooter.PFooter;
import pl.pracinho.ppaint.ui.pheader.PHeader;

import javax.swing.*;
import java.awt.*;

public class PPaint extends JFrame {

    private PHeader pHeader;
    private PFooter pFooter;
    private PCanvas pCanvas;

    public PPaint() {
        initFrame();
        initComponents();
        initView();
    }

    private void initView() {
        Container main = this.getContentPane();
        main.setLayout(new BorderLayout());
        main.add(pHeader, BorderLayout.NORTH);
        main.add(pCanvas, BorderLayout.CENTER);
        main.add(pFooter, BorderLayout.SOUTH);
    }

    private void initComponents() {
        pHeader = new PHeader();
        pFooter = new PFooter();
        pCanvas = new PCanvas();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(700, 500));
        this.setLocationRelativeTo(null);
        this.setTitle(Properties.NAME + " " + Properties.VERSION);
    }
}