package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.psizeitem;

import javax.swing.*;
import java.awt.*;

public class PSizeItem extends JPanel {

    private int itemSize;

    public PSizeItem(int itemSize) {
        this.itemSize = itemSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, itemSize, 0);
    }

    @Override
    public String toString() {
        return String.valueOf(itemSize);
    }

    public int getItemSize() {
        return itemSize;
    }
}