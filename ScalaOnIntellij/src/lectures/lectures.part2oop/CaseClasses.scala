package lectures.lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class params promoted to fields.
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. Sensible toString
  // println(instance) = println(instance.toString)
  println(jim.toString)
  println(jim)

  // 3. equals and hashcode implemented
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)
  println(jim == jim3)

  // 5. Have companionObjects
  val thePerson = Person
  val mary = Person("Mary", 22)
  println(mary)

  // 6. CCs are serializable
  // Akka framework

  // 7. Have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }


}
