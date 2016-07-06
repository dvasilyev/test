package graphics

import java.awt.{Color, Graphics}

/**
  * @author Dmitry Vasilyev.
  */
class EGraphics(g: Graphics, cellSize: Int) {
  def fillCell(x: Int, y: Int) {
    g.drawRect(getCellX(x), getCellY(y), cellSize, cellSize)
  }

  def drawString(x: Int, y: Int, msg: String) {
    g.drawString(msg, getCellX(x) + cellSize / 2, getCellY(y) + cellSize / 2)
  }

  private def getCellY(y: Int): Int = {
    return (y + 1) * cellSize
  }

  private def getCellX(x: Int): Int = {
    return ((x + 0.5) * cellSize).toInt
  }

  def setColor(color: Color) {
    g.setColor(color)
  }

  def drawCircle(x: Int, y: Int, r: Int) {
    g.drawOval(x - r, y - r, 2 * r, 2 * r)
  }
}
