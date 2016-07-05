package ui

import java.awt.event.{KeyAdapter, KeyEvent}
import java.awt.{Color, Dimension, Graphics2D}
import java.util.concurrent.TimeUnit
import javax.swing.JFrame

import test.{EGraphics, EObject}

/**
  * @author Dmitry Vasilyev.
  */
class SFrame extends JFrame("SFrame") {
  private val scale: Int = 200

  private var objects: List[EObject] = List()

  @volatile var xDirection: Int = 1

  @volatile var yDirection: Int = 0

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  setPreferredSize(new Dimension(2 * scale, 2 * scale))
  pack()
  setVisible(true)

  new Thread().start()
  new Thread(new Runnable {
    override def run(): Unit = {
      while (!Thread.currentThread.isInterrupted) {
        val g: Graphics2D = getGraphics.asInstanceOf[Graphics2D]
        g.clearRect(0, 0, 2 * scale, 2 * scale)
        g.setColor(Color.BLACK)
        val eg: EGraphics = new EGraphics(g, 30)
        objects.foreach(o => o.draw(eg))
        try {
          TimeUnit.MILLISECONDS.sleep(175)
        } catch {
          case ignored: InterruptedException =>
        }
      }
    }
  }).start()

  addKeyListener(new KeyAdapter() {
    override def keyPressed(e: KeyEvent) {
      e.getKeyCode match {
        case 37 =>
          xDirection = -1
          yDirection = 0
        case 38 =>
          xDirection = 0
          yDirection = -1
        case 39 =>
          xDirection = 1
          yDirection = 0
        case 40 =>
          xDirection = 0
          yDirection = 1
      }
    }
  })

  def add(eObjects: EObject*) {
    eObjects.foreach(eO => objects = eO :: objects)
  }

}
