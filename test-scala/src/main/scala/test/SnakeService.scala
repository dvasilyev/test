package test

import java.util.concurrent.TimeUnit

import snake.Snake

/**
 * Created by Dmitry on 17.01.2016.
 */
object SnakeService {

  def add(frame: EFrame, cells: List[ECell]) = {
    cells.foreach(cell => frame.add(cell))
  }

  def run(frame: EFrame) = {
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
