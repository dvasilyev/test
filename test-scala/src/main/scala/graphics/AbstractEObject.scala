package graphics

/**
  * @author Dmitry Vasilyev.
  */
abstract class AbstractEObject extends EObject {
  override def draw(eg: EGraphics): Unit
}
