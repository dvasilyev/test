package test

/**
 * @author Dmitry Vasilyev.
 */
object Nothing extends Number {
  override def +(arg: Number): Number = arg

  override def -(arg: Number): Number = arg
}
