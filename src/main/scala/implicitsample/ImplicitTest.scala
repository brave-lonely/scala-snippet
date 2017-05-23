package implicitsample

/**
  * Created by xiangyang on 2017/5/22.
  */
object ImplicitTest extends App {


  // implicit class

  implicit class PolitInt(num: Int) {
    def sayHello = println("Hello" + num)
  }

  32.sayHello

  // implicit  parameter
  def greeting(name: String)(implicit word: String) = println(word + name)


  // 必须是 val
  implicit  val aa:String="sdfsdf"
  greeting("sdfdf")

}
