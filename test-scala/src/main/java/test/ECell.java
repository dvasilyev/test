package test;

/**
 * Created by Dmitry on 17.01.2016.
 */
public class ECell implements EObject {
    private int x;
    private int y;

    public ECell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(EGraphics g) {
        g.fillCell(x, y);
    }
}
