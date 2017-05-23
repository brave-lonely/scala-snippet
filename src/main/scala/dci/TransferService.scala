package dci

/**
  * Created by xiangyang on 2017/5/22.
  */

// trait + 自类型的依赖注入  =  cake pattern
// trait + case class + 模式匹配 = ADT(代数数据类型)
// trait + implicit = typeclass(类型类)

case class Account(name: String, var balance: Double)

trait TransferSource {
  this: Account =>

  def transferOut(money: Double) = balance -= money
}

trait TransferTarget {
  this: Account =>

  def transferIn(money: Double) = balance += money
}

object TransferService {
  def transfer(source: TransferSource, target: TransferTarget, money: Double) = {
    source.transferOut(money)
    target.transferIn(money)
  }
}

object TransferApp extends App {
  val source = new Account("a", 100) with TransferSource
  val target = new Account("b", 100) with TransferTarget
  TransferService.transfer(source, target, 50)
  println(source.balance)
  println(target.balance)
}


