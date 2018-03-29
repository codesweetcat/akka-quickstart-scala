package akkaTutorie

/**
  * Created by hwang on 07/03/2018.
  */

import scala.async.Async
import scala.concurrent.Future
import  scala.concurrent.ExecutionContext.Implicits.global

object ScalaAsyncBasicApp extends App{

  val num1 = Future(10)
  val num2 = Future(20)

  val forOutput = for{
    no1 <- num1
    no2 <- num2
  } yield no1 + no2

  Thread.sleep(1000)

  println(s"for comprehension addition output: ${forOutput.value}")

  //scala Future API example
  val futureOutput = num1.map{no1 =>
    num2.map{ no2 => no1 + no2 }
  }
  Thread.sleep(1000)
  println(s"Scala Future API addition output:")
}
