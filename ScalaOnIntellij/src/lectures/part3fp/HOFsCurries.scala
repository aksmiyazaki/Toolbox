package lectures.part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // Higher

  // Map, flatMap, filter, MyList

  // Function that applies a function n times over a value
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x: Int) : Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne:Int => Int =  _ + 1
  println(nTimes(plusOne, 10, 1))

  // ntb(f,n) = x => f(f(f...(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int) : (Int => Int) =
    if(n <= 0)(x: Int) => x
    else (x:Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // Curried Functions
  val superAdder: Int => Int => Int = (x:Int) => (y:Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x:Double): String = c.format(x)
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")
  println(standardFormat(math.Pi))
  println(preciseFormat(math.Pi))

  /*
        1. Expand MyList
          - foreach method A => Unit
            [1,2,3].foreach(x=> println(x))

          - sort function ((A,A) => Int)
            [1,2,3].sort((x,y) => y - x)

          - zipWith (List, (A,A) => B) => MyList[B]
            [1,2,3].zipWith([4,5,6], x*y) => [4, 10, 18]

          - fold
            startValue(start)(function) => a value
            [1,2,3].fold(0)(x+y) = 6

         2. toCurry(f: (Int, Int) => Int => (Int=> Int=> Int)
         3. fromCurry(f: (Int=> Int=> Int)) => (Int, Int) => Int
         4. compose(f,g) => x=> f(g(x))
            andThen(f,g) => x => g(f(x))
   */


  def toCurry(f : (Int, Int) => Int) : (Int => Int => Int) = {
    a: Int => b: Int => f(a,b)
  }

  val x = toCurry(_ + _)
  println(x(3)(5))
  val superAdder2 : (Int => Int => Int) = x
  def add4 = superAdder2(4)
  println("add4 " + add4(17))

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (a: Int, b: Int) => f(a)(b)
  }

  val y = fromCurry(x)
  println(y(3, 5))

  def compose[A,B,T](f:A => B, g: T => A) : T => B = {
    x => f(g(x))
  }

  def andThen[A,B,C](f:A => B, g: B => C) : A => C = {
    x => g(f(x))
  }

  val add2 = (x:Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))

}
