package test

/**
 * @author Dmitry Vasilyev.
 *         http://www.otstavnov.com/Odersky_Scala_lecture-notes.html
 */
class Rational(x: Int, y: Int) extends Number {
  def numer = x

  def denom = y

  def this(module: Int) = {
    this(module, module)
  }

  override def toString = numer.toString + "/" + denom.toString

  def add(arg: Rational): Rational = new Rational(arg.numer + numer, arg.denom + denom)

  def -(arg: Rational) = new Rational(numer - arg.numer, denom - arg.denom)

  override def +(arg: Number): Number = new Rational(1,1)

  override def -(arg: Number): Number = new Rational(1,1)
}
