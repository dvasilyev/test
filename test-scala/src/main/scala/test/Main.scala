package test

import java.awt._
import javax.swing.JFrame

import scala.collection.LinearSeq

/**
 * Created by Silent on 15.11.2015.
 */
object Main {
  def hierarchicalOut(arg: String): Unit = {
    if (arg.isEmpty) {
      return
    }
    println(arg)
    hierarchicalOut(arg.substring(1))
  }

  def main(args: Array[String]) {
    println("We're running scala..")
//    var str:String = "testString"
//    val service = new JavaService
//    println(service.message)
//    var af = (a: String) => "[a " + a + " a]"
//    af = af.andThen((b: String) => "{b " + b + " b}")
//    println(af.apply("input"))
//    service.doScalaF(af)

    val frame: Frame = new Frame(200, 100)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setPreferredSize(new Dimension(600, 400))
    frame.pack()
    frame.setVisible(true)

    val points: Seq[Point] = LinearSeq[Point](new Point(100,200), new Point(3,4))

//    val jp: JPanel = new JPanel() {
//      var g2: Graphics2D = null
//      override def printComponent(g: Graphics) {
//        super.printComponent(g)
//        g2 = (Graphics2D) g
//      }
//    }
    val g: Graphics = frame.getContentPane.getGraphics
    g.setColor(Color.black)
    points.foreach(p => g.drawLine(-p.x, -p.y, p.x, p.y))
//    g.drawPolygon(new Polygon(xs,ys,5))
    println(frame.getWidth)
    println(frame.getHeight)
    frame.foo()

  }
}
