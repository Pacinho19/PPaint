package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.model.PColor;
import pl.pracinho.ppaint.utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static javax.swing.SwingUtilities.isLeftMouseButton;


public class PColors extends JPanel {

    public static PSelectedColor colorOne;
    public static PSelectedColor colorTwo;

    private JButton moreColors;
    private JPanel colorsPanel;


    public PColors() {
        initComponents();
        initView();
        initActions();
    }

    private void initActions() {
        moreColors.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                Color color = JColorChooser.showDialog(
                        PColors.this,
                        "Choose Color",
                        null);

                if (color == null) return;
                setColorByClick(e, color);
            }
        });
    }

    private void setColorByClick(MouseEvent e, Color color) {
        if (isLeftMouseButton(e)) setSelectedColorOne(color);
        else setSelectedColorTwo(color);
    }

    private void initComponents() {
        colorOne= new PSelectedColor("Color1", Color.BLACK);
        colorTwo= new PSelectedColor("Color2", Color.WHITE);

        moreColors = new JButton("More");

        colorsPanel = new JPanel(new SpringLayout());
    }

    private void initView() {
        this.setBorder(BorderFactory.createTitledBorder("Colors"));
        this.setLayout(new BorderLayout());

        initColorsPanel();

        colorsPanel.add(moreColors);
        colorsPanel.add(selectedColorsPanel());

        SpringUtilities.makeCompactGrid(colorsPanel,
                1, PColor.values().length + 2,
                5, 5,
                5, 5);

        this.add(colorsPanel, BorderLayout.CENTER);
    }

    private JPanel selectedColorsPanel() {
        JPanel main = new JPanel(new BorderLayout());
        main.add(colorOne, BorderLayout.NORTH);
        main.add(colorTwo, BorderLayout.SOUTH);
        return main;
    }

    private void initColorsPanel() {
        PColor[] colors = PColor.values();
        List.of(colors)
                .forEach(pc -> colorsPanel.add(createButton(pc)));
    }


    private JButton createButton(PColor pc) {
        JButton b = new JButton();
        b.setBackground(pc.getColor());
        b.addMouseListener(selectColor(pc.getColor()));
        return b;
    }

    private MouseAdapter selectColor(Color color) {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setColorByClick(e, color);
            }
        };
    }

    private void setSelectedColorOne(Color color) {
        colorOne.setColor(color);
    }

    private void setSelectedColorTwo(Color color) {
        colorTwo.setColor(color);
    }

}