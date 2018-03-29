package akkaTutorie

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by hwang on 04/03/2018.
  */
object ActorCountDown extends App{

  case class StartCounting(n:Int,other: ActorRef)
  case  class CountDown(n:Int)

  class CountDownActor extends  Actor{
    def receive = {

      case StartCounting(n,other)=>
        println(n)
        //send the message to other message, tell the other actor to do countDown from one less
        other ! CountDown(n-1)

      case  CountDown(n) =>
        println(self)
        if(n>0){
          println(n)
          //all actor have a method define in them called sender, send message backe to the sender
          sender ! CountDown(n-1)
        }else{
          //stop everthing, need use context to find system to terminate
          context.system.terminate();
        }

    }
  }

  val system = ActorSystem("SimpleSystem")
  val actor1 = system.actorOf(Props[CountDownActor], "CountDown1")
  val actor2 = system.actorOf(Props[CountDownActor], "CountDow2")

  actor1 ! StartCounting(10,actor2)
}
