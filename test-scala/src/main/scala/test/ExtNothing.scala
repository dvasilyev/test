package test

/**
 * @author Dmitry Vasilyev.
 */
object ExtNothing extends Number {
  override def +(arg: Number): Number = arg

  override def -(arg: Number): Number = arg
}
