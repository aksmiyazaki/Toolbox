package lectures.lectures.part2oop

object Generics extends App {
  // Generics declaration also works for traits
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }
  // generic methods
  class MyMap[Key, Value] {

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // List[Cat] extends List[Animal]?
  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? Hard question => Return list of animals

  // 2. No = INVARIANCE
  class InvariantList[A]
  //val invariantAnimalList : InvariantList[Animal] = new InvariantList[Cat]

  // 3. Hell, No! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList : ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer : Trainer[Cat] = new Trainer[Animal]

  // Bounded Types
  // A must be a subtype of animal
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)

  // must be a supertype of animal.
  class Cage2[A >: Animal] (animal: A)

  //class Car
  //val cage2 = new Cage(new Car)


  // expand MyList to be Generic
  //
}

