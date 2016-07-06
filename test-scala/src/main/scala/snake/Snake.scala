package snake

import java.awt.Color

import graphics.{AbstractEObject, EGraphics}
import test.EGraphics


/**
  * Created by Dmitry on 17.01.2016.
  */
class Snake(length: Int, x: Int, y: Int) extends AbstractEObject {

  val color: Color = {
    length match {
      case i if i > 10 => Color.blue
      case _ => Color.BLACK
    }
  }
  var elements: List[SnakePart] = {
    var out: List[SnakePart] = List()
    for (i <- 0 until length) {
      out = new SnakePart(i, x, y) :: out
    }
    out
  }

  override def draw(g: EGraphics): Unit = {
    g.setColor(color)
    elements.foreach(element => element.draw(g))
  }

  def move(xDirection: Int, yDirection: Int): Unit = {
    elements
      .zip((new SnakePart(-1, elements.head.x + xDirection, elements.head.y + yDirection) :: elements).toStream)
      .reverse
      .foreach(pair => {
        pair._1.x = pair._2.x
        pair._1.y = pair._2.y
      })
  }
}
