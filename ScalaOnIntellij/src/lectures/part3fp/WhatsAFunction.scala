package lectures.part3fp

object WhatsAFunction extends App {
  // OBJ: use functions as first class elements
  // Problem: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder:((Int, Int) => Int) = (v1: Int, v2: Int) => v1 + v2

  println(adder(22, 22))

  val stringConcatenator: ((String, String) => String) = (v1: String, v2: String) => s"$v1$v2"

  println(stringConcatenator("potato", "tomato"))

  def fun(anInt: Int) : (Int) => Int = {
    val adder:(Int => Int) = (v1:Int) => anInt + v1
    adder
  }

  val x = fun(3)
  println(x)
  println(x(4))
  // Curried function
  println(fun(3)(4))

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd)
  println(superAdd(4)(3))
  // Curried function

}


trait MyFunction[A, B] {
  def apply(element: A) : B = ???
}