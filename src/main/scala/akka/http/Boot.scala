package akka.http

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.router.RouterTest
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.RouteResult
import akka.http.scaladsl.server.directives.LogEntry
import akka.stream.ActorMaterializer

import scala.io.StdIn

/**
  * Created by xiangyang on 2017/5/8.
  */
object Boot extends App with RouterTest {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  // 准备路由
  def extractLogEntry(req: HttpRequest): RouteResult => Option[LogEntry] = {
    case RouteResult.Complete(res) => Some(LogEntry(req.method.name + " " + req.uri + " => " + res.status, Logging.InfoLevel))
    case _ => None // no log entries for rejections
  }

  val router = logRequestResult(extractLogEntry _) {
    pathPrefix("test") { routerTest}

  }


  val bindingFuture = Http().bindAndHandle(router, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done


}
