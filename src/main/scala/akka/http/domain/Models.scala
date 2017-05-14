package akka.http.domain

import akka.Done
import spray.json.DefaultJsonProtocol
//import spray.json.DefaultJsonProtocol._

import scala.concurrent.Future

/**
  * Created by xiangyang on 2017/5/8.
  */
trait Models extends  DefaultJsonProtocol{

  final case class Item(name: String, id: Long)

  final case class Order(items: List[Item])

  implicit val itemFormat = jsonFormat2(Item);

  implicit val orderFormat = jsonFormat1(Order);

  def fetchItem(itemId: Long): Future[Option[Item]] = ???

  def saveOrder(order: Order): Future[Done] = ???

}
