

/**
  * List[(String),(String)]  to  Map[String, List[String]]
  *
  * */
object RESTFulAPIs extends App {

  val listOfAPIs = List(("GET","/user/:id"),
                        ("GET", "user/:id/profile/:p_id"),
                        ("POST", "/user"),
                        ("POST", "/profile"),
                        ("PUT", "/user/:id")
  )


/*
*List[(String),(String)] to Map[(String), List[(String),(String)]]
* groupBy, defined in the TraversableLike trait, which converts our List[(String,
String)] to a Map[String, List[String]] grouped by the first element of
the tuple, the method names. This groupBy operation gives us this:
Map(POST -> List((POST,/user), (POST,/profile)),
    GET ->
    List((GET,/user/:id), (GET,user/:id/profile/:p_id)),
    PUT ->
    List((PUT,/user/:id)))
*
* */
val groupedListOfAPIs = listOfAPIs.groupBy(_._1)

  /*
  *
  * Map[(String),List[(String),(String)]]  to Map[(String),List[String]]
  *
  * mapValues method from MapLike trait, which is used to wrap the given
  *  map with the same key
  * */

  val apisByMethod = groupedListOfAPIs.mapValues(_.map(_._2))

  println(s"APIs By Method :: ${apisByMethod}")



}
