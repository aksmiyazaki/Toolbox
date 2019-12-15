//package exercises
//
//import scala.annotation.tailrec
//
//
//
//object ExecTest2$ extends App{
//  abstract class MyList [+A] {
//    def head: A
//    def tail: MyList[A]
//    def isEmpty: Boolean
//    def add[B >: A](element: B) : MyList[B]
//    def makeString: String
//    override def toString: String = s"[$makeString]"
//  }
//
//  object Empty extends MyList[Nothing] {
//    def head : Nothing = throw new NoSuchElementException
//    def tail: MyList[Nothing] = throw new NoSuchElementException
//    def isEmpty : Boolean = true
//    def add[B >: Nothing](element: B) : MyList[B] = new Cons(element, Empty)
//    def makeString : String = ""
//  }
//
//  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
//    def head : A = h
//    def tail: MyList[A] = t
//    def isEmpty: Boolean = false
//    def add[B >: A](element: B) : MyList[B] = new Cons(element, this)
//    def makeString : String = {
//      @tailrec def auxMakeString(curVal:MyList[A], accumulator:String): String = {
//        if(curVal.isEmpty) accumulator
//        else auxMakeString(curVal.tail, s"$accumulator ${curVal.head}")
//      }
//
//      auxMakeString(this, "" )
//    }
//  }
//
//
//  val listOfIntegers:MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val listOfStrings:MyList[String] = new Cons("Hello", new Cons("Scala", Empty))
//
//  println(listOfIntegers.toString)
//  println(listOfStrings.toString)
//}