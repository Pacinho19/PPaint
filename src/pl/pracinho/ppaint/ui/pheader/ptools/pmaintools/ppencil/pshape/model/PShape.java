package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.model;

public enum PShape {

    OVAL(PShapeColor.NO_FILL, PPaintMethod.DRAW_OVAL),
    OVAL_FILL(PShapeColor.FILL, PPaintMethod.FILL_OVAL),
    RECTANGLE(PShapeColor.NO_FILL, PPaintMethod.DRAW_RECT),
    RECTANGLE_FILL(PShapeColor.FILL, PPaintMethod.FILL_RECT);

    private PShapeColor pShapeColor;
    private PPaintMethod pPaintMethod;

    PShape(PShapeColor pShapeColor, PPaintMethod pPaintMethod) {
        this.pShapeColor = pShapeColor;
        this.pPaintMethod = pPaintMethod;
    }

    public PShapeColor getPShapeColor() {
        return pShapeColor;
    }

    public PPaintMethod getPPaintMethod() {
        return pPaintMethod;
    }
}
