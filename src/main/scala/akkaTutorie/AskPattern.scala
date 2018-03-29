package akkaTutorie

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by hwang on 04/03/2018.
  */
object AskPattern extends App{

  case object AskName
  case class NameResponse(name: String)


  object AskActor{
    def props(name: String): Props = Props(new AskActor(name))
  }

  class AskActor(name:String) extends Actor{

    def receive = {
      case AskName=>  sender ! NameResponse(name)
    }
  }


  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(AskActor.props("pat"),"AskActor")

  implicit  val timeout = Timeout(1 seconds)
  val answer = actor ? AskName
  answer.foreach(n=>println("name is " +n))
  system.terminate()
}
