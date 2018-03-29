



object PersonShow extends App {

  val person1 = Person("Haoming", 20,'s')
  val person2 = Person("yufeng", 22, 'p')

  val persons = List(person1,person2)

  val selectedPerson = for {
    p <- persons
    name = p.name
    age = p.age
    if age < 21
    //&& name.startsWith("H")
  } yield name
//  {
//    println(s"(this person is : ${name})")
//  }
  selectedPerson foreach(println)
    case class Person(name: String, age: Int, catagory: Char)

}
