package lectures.part3fp

object TupleAndMaps extends App {

  // Tuples
  val aTuple = (2, "Hello, Scala")
  println(aTuple)
  println(aTuple._1)
  println(aTuple.copy(_2 = "Goodbye, Java"))
  println(aTuple.swap)

  // Maps
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1)
  println(phoneBook)

  // Map Ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary"))

  // Add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // Functionals on maps
  // Map, flatmap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("J")))

  // mapValues
  println(phoneBook.mapValues(number => number * 10))

  // Conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

//  val newPair =
  // 1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900 and map
  // everything to lower case? Only the last occurrence survives.
  val exerPhoneBook = newPhoneBook + ("JIM" -> 900)
  println(exerPhoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // 2. Overly Simplified social network based on maps.
  // Person - String
  // Map -> LsOfFriends
  // - Add a person to the network
  // - Remove person from network
  // - friend (mutual)
  // - unfriend
  // - Number of friends of a person
  // - person with most friends
  // - how many people have NO friends
  // - if there is a social connection between two people (direct or not)
}
