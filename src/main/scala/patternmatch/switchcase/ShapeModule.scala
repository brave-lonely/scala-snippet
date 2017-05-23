package patternmatch.switchcase

/**
  * Created by xiangyang on 2017/5/22.
  */
object ShapeModule {

  trait Shape

  case class Square(side: Double) extends Shape

  case class Circle(radius: Double) extends Shape

  def area(shape: Shape) = shape match {
    case Square(side) => side * side
    case Circle(radius) => 3.14 * radius * radius
  }
}
