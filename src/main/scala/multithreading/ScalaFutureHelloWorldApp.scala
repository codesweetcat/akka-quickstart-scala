package multithreading

/**
  * Created by hwang on 06/03/2018.
  */
object ScalaFutureHelloWorldApp extends App{
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  val helloWorldFuture1 = Future("Hello world")
  val helloWorldFuture2 = Future{
    "Hello world"
  }
  println (helloWorldFuture1)
  println(helloWorldFuture2.value.get)

}
