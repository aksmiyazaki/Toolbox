package lectures.part2oop

object InheritanceAndTraits extends App {

    // Single class inheritance
    sealed class Animal {
        val creatureType = "Wild"
        //private def eat = println("nomnom")
        //protected def eat = println("nomnom")
        def eat = println("nomnom")
    }

    class Cat extends Animal {
        def crunch = {
            eat
            println("crunch crunch")
        }
    }

    val cat = new Cat
    cat.crunch

    // constructors
    class Person(name: String, age:Int) {
        def this(name: String) = this(name, 0)
    }
    class Adult(name:String, age: Int, idCard: String) extends Person(name, age)
    class Adult2(name:String, age: Int, idCard: String) extends Person(name)

    // overriding
    class Dog extends Animal {
        override val creatureType = "Domestic"
        override def eat = println("Crunch, Crunch")
    }

    class Dog2(override val creatureType: String) extends Animal {
        override def eat = {
            super.eat
            println("Crunch, Crunch")
        }
    }

    val dog = new Dog
    dog.eat
    println(dog.creatureType)

    val dog2 = new Dog2("K9")
    println(dog2.creatureType)

    // type substitution / polymorphism
    val unkownAnimal: Animal = new Dog2("K9")
    unkownAnimal.eat

    // overRIDING vs overLOADING

    // super

    // preventing overrides
    // 1- keyword final on member - prevents overrides
    // 2- final on class - prevents the entire class to be extended
    // 3- seal the class = extend classes in THIS FILE, prevent extension in other files
    //
}
