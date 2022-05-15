package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.psizeitem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class PSizeItemRenderer extends BasicComboBoxRenderer {

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);

        PSizeItem pSizeItem = (PSizeItem) value;
        JPanel jPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawString(pSizeItem.toString(), 5,  pSizeItem.getItemSize()>10 ?  pSizeItem.getItemSize() :  pSizeItem.getItemSize()+5 );
                g.fillRect( 25, 5, 200, pSizeItem.getItemSize());
            }
        };
        jPanel.setPreferredSize(new Dimension(100,pSizeItem.getItemSize() + 10));
        return jPanel;
    }

}