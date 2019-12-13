package lectures.part3fp

object AnonymousFunctions extends App {
  // Anonymous functions (Lambda)
  val doubler = (x: Int) =>  x * 2

  // Multiple params
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // No params
  val justDoSomething = () => 3

  // Careful
  println(justDoSomething) // function ref
  println(justDoSomething()) // call

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR synthatic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _  // equivalent to (a, b) => a + b

}
