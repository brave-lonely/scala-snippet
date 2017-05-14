package akka.http.router

import akka.Done
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Route
import akka.http.domain.Models

import scala.concurrent.Future

/**
  * Created by xiangyang on 2017/5/8.
  */
trait RouterTest extends Models {

  val route1: Route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }

  val route2: Route =
    get {
      pathPrefix("item" / LongNumber) { id =>
        // there might be no item for a given id
        val maybeItem: Future[Option[Item]] = fetchItem(id)

        onSuccess(maybeItem) {
          case Some(item) => complete(item)
          case None => complete(StatusCodes.NotFound)
        }
      }
    } ~
      post {
        path("create-order") {
          entity(as[Order]) { order =>
            val saved: Future[Done] = saveOrder(order)
            onComplete(saved) { done =>
              complete("order created")
            }
          }
        }
      } ~
      get {
        path("order" / LongNumber) { id =>
          complete(Item("thing", 42))
        }
      } ~
      post {
        path("create-orders") {
          entity(as[Order]) { order =>
            val itemsCount = order.items.size
            val itemNames = order.items.map(_.name).mkString(",");
            complete(s"$itemsCount   $itemNames")
          }
        }
      }

  def routerTest = route1 ~ route2

}
