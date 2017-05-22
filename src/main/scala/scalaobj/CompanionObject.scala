package scalaobj

/**
  * Created by xiangyang on 2017/5/14.
  */

//用object 创建单例
object StringUtil {
  def increment(s: String) = s.map(c => (c + 1).toChar);
}

// 在同一个文件中定义对象和类，并赋予相同的名字
// 在对象内定义"静态"成员
// 在类内定义非静态成员
class Pizza(var crustType: String) {

  override def toString: String = "Crust type is " + crustType

  def apply(x: Int): Int = x
}

//用伴生类创建静态成员
object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"

  def apply(x: Int, y: Int): Int = ???

}

object CompanionObject extends App {
  val p =new Pizza(Pizza.CRUST_TYPE_THICK);

}
