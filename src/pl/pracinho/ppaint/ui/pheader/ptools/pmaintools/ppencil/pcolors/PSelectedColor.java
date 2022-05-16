package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors;

import pl.pracinho.ppaint.utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;

public class PSelectedColor extends JPanel {

    public Color color;

    private String labelS;

    public PSelectedColor(String labelS, Color colorInput) {
        this.labelS = labelS;

        initComponents();
        initView();

        setColor(colorInput);
    }

    private void initView() {
        this.add(info);
        this.add(colorP);
        SpringUtilities.makeCompactGrid(this,
                1, 2,
                5, 5,
                5, 5);
    }

    private void initComponents() {
        info = new JLabel(labelS);
        colorP = new JPanel();
    }

    public void setColor(Color colorInput) {
        color = colorInput;
        colorP.setBackground(colorInput);
    }

    public Color getSelectedColor() {
        return color;
    }

    private JLabel info;
    private JPanel colorP;
}
