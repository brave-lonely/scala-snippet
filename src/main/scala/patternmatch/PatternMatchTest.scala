package patternmatch

/**
  * Created by xiangyang on 2017/5/22.
  */
object PatternMatchTest extends App {

  val x: String = "1"
  x match {
    case "1" => println("its 1")
    case _ => println("UNKNOW")
  }


  //匹配 case class
  case class Address(lane: String, no: String)

  case class User(name: String, email: String, address: Address)

  val u1 = User("zhangsan", "sdf@wer", Address("sd", "sdf"))
  u1 match {
    case User(_, _, addr@Address(_, no)) => println(no + "-----" + addr)
    case _ => println("no match")
  }

  // 匹配 List
  val list = List(1, 2, 3)
  list match {
    case List(1, _, n) => println(n)
    case _ => println("no match")
  }
  // 匹配 tuple
  val pair = (1, 2, 4)
  pair match {
    case (1, _, n) => println(4)
    case _ => println("no match")
  }

  val n: Any = 1
  n match {
    case x: Int if x > 1 => println("its a big int")
    case x: Int => println("its a small int")
    case x: String => println("its a string")
  }
  val (i, j) = (1, 2)
  println(i)
  println(j)
  val map = Map(1 -> "1", 2 -> "2")
  map.map{case (k,v)=> s"key=$k,value=$v"}.foreach(println)

}
