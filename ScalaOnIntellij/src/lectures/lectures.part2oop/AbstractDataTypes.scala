package lectures.part2oop

object AbstractDataTypes extends App{

    // abstract
    abstract class Animal {
        val creatureType: String = "Wild"
        def eat: Unit
    }

    class Dog extends Animal {
        override val creatureType: String = "Canine"
        def eat: Unit = print("crunch crunch") // you can use without override.
    }

    // traits
    trait Carnivore {
        def eat(animal: Animal): Unit
        val preferredMeal: String = "fresh meat"
    }

    trait ColdBlooded

    class Crocodile extends Animal with Carnivore with ColdBlooded {
        override val creatureType: String = "croc"
        def eat(animal: Animal): Unit = println(s"I'm a Croc and I'm eating ${animal.creatureType}")
        def eat: Unit = println("nomnomnom")
    }

    val dog = new Dog
    val croc = new Crocodile
    croc.eat(dog)

    // traits vs abstract classes
    // 1 - Traits do not have constructor parameters.
    // 2 - Multiple traits may be inherited by the same class
    // 3 - Traits - behavior, abstract class - "thing"


}
