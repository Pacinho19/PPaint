package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.psize.psizeitem;

public class PSizeItem{

    private int itemSize;

    public PSizeItem(int itemSize) {
        this.itemSize = itemSize;
    }

    @Override
    public String toString() {
        return String.valueOf(itemSize);
    }

    public int getItemSize() {
        return itemSize;
    }
}