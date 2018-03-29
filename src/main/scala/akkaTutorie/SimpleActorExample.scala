package akkaTutorie

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by hwang on 04/03/2018.
  */
object SimpleActorExample extends App{


  class SimpleActor extends Actor {

    def receive = {
      case s: String => println(s"String: $s")
      case i: Int => println(s"Number: $i")
    }
  }
    val system = ActorSystem("simpleSystem")
    val actor = system.actorOf(Props[SimpleActor],"SimpleActor")


      println("before messages")
    actor ! "HI there"
  println("after string")
    actor ! 43
  println("after int")
  actor ! 'a'
  println("after char")



}
