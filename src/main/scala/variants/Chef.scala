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

    cutIt(cutFruit)
//    cutIt(cutApple)

}


