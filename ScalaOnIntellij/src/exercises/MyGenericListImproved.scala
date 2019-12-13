package exercises

import scala.annotation.tailrec

object ExecTest3 extends App{

  abstract class MyList [+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B) : MyList[B]
    def makeString: String
    override def toString: String = s"[$makeString]"

    // higher-order functions
    def map[B](transformer: (A) => B) : MyList[B]
    def flatMap[B](transformer: (A) => MyList[B]): MyList[B]
    def filter(predicate: (A) => Boolean): MyList[A]
    def foreach[B >: A](fun: (B => Unit)): Unit
    def sort[B >: A](fun: ((B, B) => Int)): MyList[B]
    def zipWith[B, C](list: MyList[B], fun: ((A, B) => C)) : MyList[C]
    def fold[B](start: B)(fun: (B,A) => B) : B

    def ++[B >: A](list: MyList[B]) : MyList[B]
  }

  object Empty extends MyList[Nothing] {
    def head : Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty : Boolean = true
    def add[B >: Nothing](element: B) : MyList[B] = new Cons(element, Empty)
    def makeString : String = ""

    override def map[B](transformer: (Nothing) => B) : MyList[B] = Empty
    override def flatMap[B](transformer: (Nothing) => MyList[B]) : MyList[B] = Empty
    override def filter(predicate: Nothing => Boolean) : MyList[Nothing] = Empty
    override def foreach[B >: Nothing](fun: B => Unit): Unit = ()
    override def sort[B >: Nothing](fun: (B, B) => Int): MyList[B] = Empty

    override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    def zipWith[B, C](list: MyList[B], fun: ((Nothing, B) => C)) : MyList[C] = {
      if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else Empty
    }

    override def fold[B](start: B)(fun: (B, Nothing) => B): B = start
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

    def flatMap[B](transformer: (A) => MyList[B]): MyList[B] = transformer(h) ++ t.flatMap(transformer)

    override def filter(predicate: (A) => Boolean): MyList[A] = {
      if(predicate(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }

    override def map[B](transformer: (A) => B) : MyList[B] = {
      new Cons(transformer(h), t.map(transformer))
    }

    override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

    override def foreach[B >: A](fun: B => Unit): Unit = {
      fun(this.head)
      if(!this.isEmpty) t.foreach(fun)
    }

    override def sort[B >: A](fun: (B, B) => Int): MyList[B] = {
      def findAndInsert(curEl: B, curList: MyList[B]): MyList[B] = {
        if(curList.isEmpty) new Cons(curEl, Empty)
        else if(fun(curEl, curList.head) < 0) new Cons(curEl, curList)
        else new Cons(curList.head, findAndInsert(curEl, curList.tail))
      }

      val sortedTail = t.sort(fun)
      findAndInsert(h, sortedTail)
    }

    override def zipWith[B, C](list: MyList[B], fun: ((A, B) => C)) : MyList[C] = {
      if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else new Cons(fun(this.head, list.head), t.zipWith(list.tail, fun))
    }

    override def fold[B](start: B)(fun: (B, A) => B): B =
      t.fold(fun(start, h))(fun)
  }

  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers.toString)

  val mapper:((Int) => Int) = (v1: Int) => v1 * 2
  println(listOfIntegers.map(mapper))

  val filterPred:((Int) => Boolean) = (v1:Int) => v1 % 2 == 0
  println(listOfIntegers.filter(filterPred))

  val anotherListOfIntegers = new Cons(4, new Cons(5, new Cons(6, Empty)))
  println((listOfIntegers ++ anotherListOfIntegers).toString)
  val anotherListOfStrings = new Cons("A", new Cons("B", new Cons("C", Empty)))

  val mapFlatPred: ((Int)) => MyList[Int] = (v1 : Int) => new Cons(v1, new Cons(v1 + 1, Empty))
  println(listOfIntegers.flatMap((mapFlatPred)))

  println("Foreach Test")
  listOfIntegers.foreach(println)

  println("SORT TEST")
  println(listOfIntegers.sort((v1: Int, v2: Int) => v2 - v1))
  println(listOfIntegers.sort((v1: Int, v2: Int) => v1 - v2))

  val ultimateListOfIntegers = listOfIntegers ++ anotherListOfIntegers
  println(ultimateListOfIntegers)
  println(ultimateListOfIntegers.sort((v1: Int, v2: Int) => v2 - v1))

  println("ZIP TEST")
  val zippedList = anotherListOfIntegers.zipWith[String, String](anotherListOfStrings, _ + "-" + _)
  println(zippedList)

  println("FOLD TEST")
  println(listOfIntegers.fold(0)(_ + _))
}