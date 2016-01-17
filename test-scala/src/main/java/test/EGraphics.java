package test;

import java.awt.*;

/**
 * Created by Dmitry on 17.01.2016.
 */
public class EGraphics {
    Graphics g;
    private int cellSize;

    public EGraphics(Graphics g, int cellSize) {
        this.g = g;
        this.cellSize = cellSize;
    }

    public void fillCell(int x, int y) {
        g.drawRect(getCellX(x), getCellY(y), cellSize, cellSize);
    }

    public void drawString(int x, int y, String msg) {
        g.drawString(msg, getCellX(x) + cellSize / 2, getCellY(y) + cellSize / 2);
    }

    private int getCellY(int y) {
        return (y + 1) * cellSize;
    }

    private int getCellX(int x) {
        return (int) ((x + 0.5) * cellSize);
    }

    public void setColor(Color color) {
        g.setColor(color);
    }

    public void drawCircle(int x, int y, int r) {
        g.drawOval(x - r, y - r, 2 * r, 2 * r);
    }
}
