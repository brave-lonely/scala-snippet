package variants

/**
  * Created by xiangyang on 2017/5/22.
  */
object Chef extends App {

  val fruit = new Fruit
  val apple = new Apple


  val cutFruit: Fruit => FruitPiece = fruit => new FruitPiece
  val cutApple: Apple => ApplePiece = apple => new ApplePiece

  def cutIt(f: Fruit => FruitPiece): FruitPiece = f(apple)

  //  cutIt(cutApple)
  val add: Int => Int = a => a + 1
  def add2: Int => Int = {a => a + 1}
  println(add2==add2)
  println(add2 eq add2)
}


