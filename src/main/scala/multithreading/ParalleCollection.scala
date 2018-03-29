package multithreading



import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.io.StdIn._
/**
  * Created by hwang on 04/03/2018.
  */
object ParalleCollection extends App{
  println("this is first")
 val f = Future {
   println("Printing in the future ")
 }
  Thread.sleep(10)
  println("this is last")

  val f2= Future {
    for(i <- 1 to 30)yield ParallelCollect.fib(i)
//    throw new RuntimeException("Bad.")
  }
  //no bolocking , this only happen calculation successfully
  //f2.foreach(println)
//  f2.onComplete{
//    case Success(n) => println(n)
//    case Failure(ex) => println("Something went wrong"+ex)
//  }

  println(Await.result(f2, Duration("5 second")))
  readLine()
}
