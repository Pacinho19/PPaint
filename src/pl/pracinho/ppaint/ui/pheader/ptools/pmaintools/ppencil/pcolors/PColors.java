package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pcolors;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pcolors.model.PColor;
import springutilities.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class PColors extends JPanel {

    public static Color selectedColor;
    private JButton moreColors;

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

            if (out != null) selectedColor = out;
        });
    }

    private void initComponents() {
        moreColors = new JButton("More");
    }

    private void initView() {
        this.setBorder(BorderFactory.createTitledBorder("Colors"));

        this.setLayout(new SpringLayout());

        PColor[] colors = PColor.values();
        List.of(colors)
                .forEach(pc -> this.add(createButton(pc)));

        this.add(moreColors);

        SpringUtilities.makeCompactGrid(this,
                1, colors.length + 1,
                5, 5,
                5, 5);
    }

    private JButton createButton(PColor pc) {
        JButton b = new JButton();
        b.setBackground(pc.getColor());
        b.addActionListener(e -> selectedColor = pc.getColor());
        return b;
    }

}