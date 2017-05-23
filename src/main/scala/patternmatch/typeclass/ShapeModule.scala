package patternmatch.typeclass

/**
  * Created by xiangyang on 2017/5/22.
  */
object ShapeModule {

  trait Shape

  case class Square(side: Double) extends Shape

  case class Circle(radius: Double) extends Shape

  trait HaveArea[T] {
    def area(shape: T): Double
  }

  trait HavePerimeter[T] {
    def perimeter(shape: T): Double
  }

  implicit object SquareHaveArea extends HaveArea[Square] {
    override def area(shape: Square): Double = shape.side * shape.side
  }

  implicit object CircleHaveArea extends HaveArea[Circle] {
    override def area(shape: Circle): Double = shape.radius * shape.radius * 3.14
  }

  implicit object SquareHavePerimeter extends HavePerimeter[Square] {
    override def perimeter(shape: Square): Double = shape.side * 4
  }

  implicit object CircleHavePerimeter extends HavePerimeter[Circle] {
    override def perimeter(shape: Circle) = 3.14 * shape.radius * shape.radius

  }

}
