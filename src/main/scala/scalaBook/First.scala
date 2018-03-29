package scalaBook

/**
  * Created by hwang on 23/03/2018.
  */
object First extends App {

    val double: (Int => Int) = _* 2
    (1 to 10 ) foreach double   .andThen(print)


}
