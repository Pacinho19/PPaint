package pl.pracinho.ppaint.ui.pheader.ptools.pmaintools.ppencil.pshape.model;

public enum PPaintMethod {

    DRAW_OVAL("drawOval"),
    FILL_OVAL("fillOval"),
    DRAW_RECT("drawRect"),
    FILL_RECT("fillRect");

    private String name;

    PPaintMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
