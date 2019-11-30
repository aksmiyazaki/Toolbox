package exercises
import scala.annotation.tailrec


abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int) : exercises.MyList
  def makeString: String
  override def toString: String = s"[$makeString]"
}

object Empty extends MyList {
  def head : Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add(element: Int) : MyList = new Cons(element, Empty)
  def makeString : String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head : Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int) : MyList = new Cons(element, this)
  def makeString : String = {
    @tailrec def auxMakeString(curVal:MyList, accumulator:String): String = {
      if(curVal.isEmpty) accumulator
      else auxMakeString(curVal.tail, s"$accumulator ${curVal.head}")
    }

    auxMakeString(this, "" )
  }
}

object ExecTest$ extends App{
  val c : MyList  = Empty
  println(c.isEmpty)
  println(c.toString)

  val one_el = new Cons(25, Empty)
  println(one_el.head)
  println(one_el.toString())

  val two_el = new Cons(27, one_el)
  println(two_el.head)
  println(two_el.tail.head)
  println(two_el.toString())

  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString)

}