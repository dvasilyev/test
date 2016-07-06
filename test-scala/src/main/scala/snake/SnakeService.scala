package snake

import java.util.concurrent.TimeUnit

import graphics.ECell
import ui.SFrame

/**
 * Created by Dmitry on 17.01.2016.
 */
object SnakeService {

  def add(frame: SFrame, cells: List[ECell]) = {
    cells.foreach(cell => frame.add(cell))
  }

  def run(frame: SFrame) = {
    val snake = new Snake(14, 3, 2)
    frame.add(snake)
    new Thread(new Runnable {
      override def run(): Unit = {
        while (!Thread.currentThread().isInterrupted) {
          snake.move(frame.xDirection, frame.yDirection)
          TimeUnit.MILLISECONDS.sleep(175)
        }
      }
    }).run()
    //    add(frame, List(new ECell(4, 4), new ECell(4, 5)))
  }
}
