package ui

import snake.SnakeService

/**
  * @author Dmitry Vasilyev.
  */
object SFrameLauncher {
  def main(args: Array[String]) {
    SnakeService.run(new SFrame)
  }
}
