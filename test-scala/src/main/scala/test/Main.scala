package test

import java.awt.{Graphics, Polygon, Dimension}
import java.awt.event.{WindowEvent, WindowAdapter, WindowListener}
import javax.swing.JFrame

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

//    val partialFunctionSource = (a: Int, b: Int) => Math.pow(a, b)
//    val partialFunction = partialFunctionSource(2,_:Int)
//    var i:Int = 42
//    println("qqq "+partialFunction(i))
//    for (i <- 0 to 10) {
//      println(partialFunction(i))
//    }
//    println("qqq "+partialFunction(i))

//    hierarchicalOut("qwerty")

    var frame:Frame = new Frame(200,100)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setPreferredSize(new Dimension(600, 400))
    frame.pack()
    val xs: Array[Int] = Array(5,4,3,2,1)
    val ys: Array[Int] = Array(1,5,2,4,3)
    frame.setVisible(true)
    val g: Graphics = frame.getContentPane.getGraphics
    g.drawPolygon(new Polygon(xs,ys,5))
    println(frame.getWidth)
    println(frame.getHeight)
    frame.foo()
  }
}
