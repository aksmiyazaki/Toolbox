package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val list = List(1, 2 ,3)

  println(list)
  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val combine = (y: Char, x: List[Int]) => x.map(_.toString + y)
  println(chars.flatMap(combine(_, numbers)))


  val combineF = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combineF)

  val combineF2 = colors.flatMap(col => numbers.flatMap(n => chars.map(c => "" + col + n + c)))
  println(combineF2)

  // Foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + color + n + c

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // Syntax overload
  list.map { x =>
    x * 2
  }



}
