/**
  * Created by hwang on 28/03/2018.
  */
object compareIntegersV6 extends App {

  def compareIntegersV6( value1: Int=10, value2:Int ): String = {
    println("Executing V6")
    def giveAMeaningFullRequest(result: Int) = result match {
      case 0 => "Values are equal"
      case 1 => s"$value1 is bigger than $value2"
      case  -1 => s"$value1 is smaller than $value2"
      case _ => "could not perform the operation"
    }
    val res = { if(value1 == value2) 0 else if (value1 > value2) 1 else -1 }
    giveAMeaningFullRequest(res)
  }
//passing value by name
  println(compareIntegersV6(value2 = 12))

}
