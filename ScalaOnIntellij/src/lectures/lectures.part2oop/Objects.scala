package lectures.part2oop

object Object extends App {

    // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (STATIC STUFF)
    object Person { // type + its only instance
        // "Static"/"class" level functionality
        val N_EYES = 2
        def canFly: Boolean = false

        // Factory Method
        def apply(mother: Person, father: Person): Person = new Person("Bobby")
    }
    class Person(val name: String){
        // instance-level functionality
    }
    // COMPANIONS

    println(Person.N_EYES)
    println(Person.canFly)


    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    // Scala object = SINGLETON INSTANCE
    val p1 = Person
    val p2 = Person
    println(p1 == p2)

    val bobbie = Person.apply(mary, john)
    val bobbie2 = Person(mary, john) // Object used as function, seems like constructor but it's a factory

    // Scala Applications = Scala object with
    // def main(args: Array[String]) : Unit

}
