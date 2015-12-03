package test

import javax.swing.JFrame

/**
 * Created by Silent on 28.11.2015.
 */
class Frame(width: Double, height: Double) extends JFrame {

  def foo(): Unit = {
    println(width + ":" + height)
  }
}
