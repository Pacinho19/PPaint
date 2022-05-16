package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pcolors.model.PColor;
import pl.pracinho.ppaint.utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class PColors extends JPanel {

    public static Color selectedColor;

    private JButton moreColors;
    private JLabel infoSelected;

    private JPanel selectedColorPanel;
    private JPanel infoPanel;
    private JPanel colorsPanel;

    public PColors() {
        selectedColor = Color.BLACK;
        initComponents();
        initView();
        initActions();
    }

    private void initActions() {
        moreColors.addActionListener(e -> {
            Color out = JColorChooser.showDialog(
                    PColors.this,
                    "Choose Color",
                    selectedColor);

            if (out != null) setSelected(out);
        });
    }

    private void initComponents() {
        moreColors = new JButton("More");
        infoSelected = new JLabel("Selected ");

        selectedColorPanel = new JPanel();
        infoPanel = new JPanel(new SpringLayout());
        colorsPanel = new JPanel(new SpringLayout());

        setSelected(PColors.selectedColor);
    }

    private void initView() {
        this.setBorder(BorderFactory.createTitledBorder("Colors"));
        this.setLayout(new BorderLayout());

        initColorsPanel();
        initInfoPanel();

        colorsPanel.add(moreColors);
        colorsPanel.add(infoPanel);

        SpringUtilities.makeCompactGrid(colorsPanel,
                1, PColor.values().length + 2,
                5, 5,
                5, 5);
        this.add(colorsPanel, BorderLayout.CENTER);
    }

    private void initColorsPanel() {
        PColor[] colors = PColor.values();
        List.of(colors)
                .forEach(pc -> colorsPanel.add(createButton(pc)));
    }

    private void initInfoPanel() {
        infoPanel.add(infoSelected);
        infoPanel.add(selectedColorPanel);
        SpringUtilities.makeCompactGrid(infoPanel,
                1, 2,
                5, 5,
                5, 5);
    }

    private JButton createButton(PColor pc) {
        JButton b = new JButton();
        b.setBackground(pc.getColor());
        b.addActionListener(e -> setSelected(pc.getColor()));
        return b;
    }

    private void setSelected(Color color) {
        selectedColor = color;
        selectedColorPanel.setBackground(color);
    }

}