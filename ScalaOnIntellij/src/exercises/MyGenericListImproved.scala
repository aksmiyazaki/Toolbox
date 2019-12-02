package exercises

import scala.annotation.tailrec

object ExecTest3 extends App{
  trait MyPredicate[-T] {
    def test(target: T): Boolean
  }

  trait MyTransformer[-A, B]{
    def transform(target:A): B
  }

  abstract class MyList [+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B) : MyList[B]
    def makeString: String
    override def toString: String = s"[$makeString]"

    def map[B](transformer: MyTransformer[A, B]) : MyList[B]
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]

    def ++[B >: A](list: MyList[B]) : MyList[B]
  }

  object Empty extends MyList[Nothing] {
    def head : Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty : Boolean = true
    def add[B >: Nothing](element: B) : MyList[B] = new Cons(element, Empty)
    def makeString : String = ""

    override def map[B](transformer: MyTransformer[Nothing, B]) : MyList[B] = Empty
    override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
    def head : A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B) : MyList[B] = new Cons(element, this)
    def makeString : String = {
      @tailrec def auxMakeString(curVal:MyList[A], accumulator:String): String = {
        if(curVal.isEmpty) accumulator
        else auxMakeString(curVal.tail, s"$accumulator ${curVal.head}")
      }

      auxMakeString(this, "" )
    }


    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = transformer.transform(h) ++ t.flatMap(transformer)

    override def filter(predicate: MyPredicate[A]): MyList[A] = {
      if(predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }

    override def map[B](transformer: MyTransformer[A, B]) : MyList[B] = {
      new Cons(transformer.transform((h)), t.map(transformer))
    }

    override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  }

  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int) : Int = elem * 2
  }).toString)


  println((listOfIntegers.filter((new MyPredicate[Int] {
    override def test(target: Int): Boolean = target % 2 == 0
  }))).toString)

  val anotherListOfIntegers = new Cons(4, new Cons(5, Empty))

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int) : MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)
}