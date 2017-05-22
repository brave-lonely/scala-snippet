package future

/**
  * Created by xiangyang on 2017/5/14.
  */
object SimpleFuture extends App {

  def test(f: Int => Int): (Int) => Int = {
    f
  }

  println(test{n => n})

}

