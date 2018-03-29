/**
  * Created by hwang on 27/03/2018.
  */
object RecursionEx extends App {

  def recursionFunction (x: Int): Int = if(x == 0 ) 1 else 2*recursionFunction(x-1)

  println(recursionFunction(2))

}
