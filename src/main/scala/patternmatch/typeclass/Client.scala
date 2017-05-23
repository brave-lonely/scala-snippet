package patternmatch.typeclass

/**
  * Created by xiangyang on 2017/5/22.
  */
object Client  extends App{

  import patternmatch.typeclass.ShapeModule._

  def printArea[T](shape: T)(implicit m: HaveArea[T]) = println(m.area(shape))
  def printPerimeter[T](shape: T)(implicit m:HavePerimeter[T])=print(m.perimeter(shape))

  printArea(Square(1))

}
