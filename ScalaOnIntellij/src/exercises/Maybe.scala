package exercises

abstract class Maybe[+T]{

  def map[B](transformer:(T) => B) : Maybe[B]
  def flatMap[B](transformer:(T) => Maybe[B]): Maybe[B]
  def filter(predicate: (T) => Boolean) : Maybe[T]
}

case object MaybeNot extends Maybe[Nothing]{
  override def map[B](transformer: Nothing => B): Maybe[B] = MaybeNot
  override def flatMap[B](transformer: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  override def filter(predicate: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T] (Value: T) extends Maybe[T]{
  override def map[B](transformer: T => B): Maybe[B] = new Just(transformer(Value))
  override def flatMap[B](transformer: T => Maybe[B]): Maybe[B] = transformer(Value)
  override def filter(predicate: T => Boolean): Maybe[T] =
    if(predicate(Value)) this
    else MaybeNot
}

object MaybeTest extends App {
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just (x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))



}