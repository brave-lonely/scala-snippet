package function

/**
  * Created by xiangyang on 2017/5/19.
  */
object FunctionTest extends App {
  def add(num: Int) = num + 1

  def add2: Int => Int = a => a + 1

  val add3 = (x: Int) => x + 1

  val add4: Int => Int = x => x + 1


  def accept[A, B](x: A, f: A => B): B = f(x)

  accept(1, (x: Int) => x + 1)


  def accept2[A, B](x: A)(f: A => B): B = f(x)

  accept2(1)((x: Int) => x + 1)
  accept2(1)(_ + 1)


  //函数组合
  def compose[A, B, C](f1: A => B)(f2: B => C): A => C = { x => f2(f1(x)) }

  val addMult = compose((x: Int) => x + 1)((x: Int) => x * 2)

  println(addMult(3))


}
