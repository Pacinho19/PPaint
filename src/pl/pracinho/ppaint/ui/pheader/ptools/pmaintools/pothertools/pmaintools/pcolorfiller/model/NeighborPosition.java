package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.pothertools.pmaintools.pcolorfiller.model;

public enum NeighborPosition {

    LEFT(-1,0),
    TOP(0,-1),
    RIGHT(1,0),
    BOTTOM(0,1);

    private int changeX;
    private int changeY;


    NeighborPosition(int changeX, int changeY) {
        this.changeX = changeX;
        this.changeY = changeY;
    }

    public int getChangeX() {
        return changeX;
    }


    public int getChangeY() {
        return changeY;
    }

}
