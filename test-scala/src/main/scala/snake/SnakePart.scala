package snake

import test.{EGraphics, AbstractEObject}

/**
 * Created by Dmitry on 17.01.2016.
 */
class SnakePart(number: Int, xx: Int, yy: Int) extends AbstractEObject {
  var x = xx
  var y = yy
  val name = String.valueOf(number)

  override def draw(g: EGraphics): Unit = {
    g.fillCell(x, y)
    g.drawString(x, y, name)
  }
}
