package graphics

/**
  * @author Dmitry Vasilyev.
  */
class ECell(x: Int, y: Int) extends EObject {
  override def draw(g: EGraphics) {
    g.fillCell(x, y)
  }
}
