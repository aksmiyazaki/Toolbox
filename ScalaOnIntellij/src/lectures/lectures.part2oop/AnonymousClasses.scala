package lectures.lectures.part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit
  }

  // Anonymous Class
  // Compiler creates a class and instantiates.
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahaha")
  }

  /*
   equivalent with
   class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("hahahahahaha")
   }

   val funnyAnimal: Animal = new Animal = new AnonymousClasses$$anon$1
   */


  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }



}
