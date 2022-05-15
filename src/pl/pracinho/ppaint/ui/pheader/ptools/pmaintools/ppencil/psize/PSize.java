package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.psizeitem.PSizeItem;
import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.psizeitem.PSizeItemRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class PSize extends JPanel {

    public static Integer SIZE = 5;
    private final int MIN = 5;
    private final int MAX = 20;

    private JComboBox size;

    public PSize() {
        init();
        initComponents();
        initView();
        initActions();
    }

    private void initActions() {
        size.addActionListener(e -> {
            if (size.getSelectedIndex() >= 0) SIZE = ((PSizeItem) size.getSelectedItem()).getItemSize();
        });
    }

    private void initView() {
        this.add(size, BorderLayout.CENTER);
    }

    private void initComponents() {
        size = new JComboBox() {
            @Override
            public void setRenderer(ListCellRenderer aRenderer) {
                super.setRenderer(new PSizeItemRenderer());
            }
        };

        IntStream.rangeClosed(MIN, MAX)
                .boxed()
                .forEach(s -> size.addItem(new PSizeItem(s)));
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Size"));
    }
}