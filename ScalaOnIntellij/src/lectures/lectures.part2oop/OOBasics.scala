package lectures.part2oop
import scala.annotation.tailrec // import needed to @tailrec

object OOBasics extends App{
    val person = new Person("John", 26)
    println(person.age)
    person.greet("Daniel")
    person.greet

    val writer = new Writer("José", "Jacó", 1966)
    println(writer.fullName)

    val novel = new Novel("Poeira em alto mar", 1986, writer)
    novel.authorAge
    val novel_new = novel.copy(1996)
    novel_new.authorAge
    novel.authorAge

    novel.isWrittenBy(writer)
    val potato = new Writer("José", "Jacó", 1966)
    novel.isWrittenBy(potato)

    var c = new Counter
    c.inc.inc.print
    c.inc(10).print


}

class Counter(val num:Int = 0) {
    def currentCount():Int = num
    def inc():Counter = {
        println("incrementing")
        new Counter(num + 1) // immutability
    }
    def dec():Counter = {
        println("decrementing")
        new Counter(num - 1)
    }

    @tailrec final def inc(offset:Int):Counter = {
        if(offset <= 0) this
        else inc.inc(offset - 1) // Attention to this, calls inc method first and then calls the overloaded method with offset - 1.
    }

    @tailrec final def dec(offset:Int):Counter = {
        if(offset <= 0) this
        else dec.dec(offset - 1)
    }

    def print = println(num)
 }

class Writer(val firstName: String, val surName: String, val year: Int){
    def fullName():String = f"$firstName $surName"
}

class Novel(val name:String, val releaseYear: Int, val author: Writer){
    def authorAge(): Int = this.releaseYear - author.year
    def isWrittenBy(author:Writer) = this.author == author
    def copy(newReleaseYear: Int):Novel = return new Novel(this.name, newReleaseYear, this.author)
}

// Constructor
class Person(val name: String, val age : Int) {
    val x = 2

    def greet(name: String) : Unit = println(s"${this.name} says: Hi, $name")
    def greet(): Unit = println(s"Hi, I am $name")

    // multiple constructors
    def this(name: String) = this(name, 0)
    def this() = this("John Doe")
}
    // Class parameters are not fields
