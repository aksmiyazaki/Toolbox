package lectures.lectures.part2oop

object Exceptions extends App {
  val x: String =  null
//  println(x.length)

  //val aWeirdValue : String = throw new NullPointerException

  // throwable classes extend the Throwable Class.
  // Exception and Error are the major Throwable subtypes

  def getInt(withExceptions: Boolean) : Int = {
    if(withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

  val potentialFail = try{
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // Does not influence the return type of try...catch expression
    // Use only for side effects
    println("Finally")
  }

  println(potentialFail)

  // Declaring Exceptions
  class MyException extends Exception
  val exception = new MyException
  //throw exception

  // 1. Crash program with an OutOfMemoryError
//  var testStr = "potato"
//  var i = 0
//  while(true){
//    testStr = testStr + testStr
//  }

  // 2. Crash program with stackoverflow error
  /*println("Crash rec")
  def bad_recursion(acum: Int) : Int = {
    if(1 == 1) acum + bad_recursion(acum)
    else 42
  }
  bad_recursion(1)*/

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")

  object PocketCalculator {
    def add(x: Int, y: Int) : Int = {
      val res = x + y
      if(x > 0 && y > 0 && res < 0) throw new OverflowException
      else if(x < 0 && y < 0 && res > 0) throw new UnderflowException
      else x + y
    }

    def subtract(x: Int, y:Int): Int = {
      val res = x - y
      if(x > 0 && y < 0 && res < 0) throw new OverflowException
      else if(x < 0 && y > 0 && res > 0) throw new UnderflowException
      else x-y
    }

    def multiply(x: Int, y: Int): Int = {
      val res = x * y
      if((x > 0 && y > 0 && res < 0)  || (x < 0 && y < 0 && res < 0)) throw new OverflowException
      else if((x > 0 && y < 0 && res > 0) || (x < 0 && y > 0 && res > 0)) throw new UnderflowException
      else x + y
    }

    def divide(x: Int, y: Int) : Int = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.divide(10, 0))
}
