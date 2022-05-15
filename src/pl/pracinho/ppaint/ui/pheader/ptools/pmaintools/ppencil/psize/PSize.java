package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize;

import pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.psizeitem.PSizeItem;

import javax.swing.*;
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
            if (size.getSelectedIndex() >= 0)
                SIZE = ((PSizeItem) size.getSelectedItem()).getItemSize();
        });
    }

    private void initView() {
        this.add(size);
    }

    private void initComponents() {
        size = new JComboBox();
        IntStream.rangeClosed(MIN, MAX)
                .boxed()
                .forEach(s -> size.addItem(new PSizeItem(s)));
    }

    private void init() {
        this.setBorder(BorderFactory.createTitledBorder("Size"));
    }
}