package lectures.part2oop


object MethodNotations extends App {
    class Person(val name: String, favoriteMovie: String, val age:Int = 0){
        def likes(movie: String): Boolean = movie == favoriteMovie
        def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
        def +(nickname: String) : Person = new Person(s"${this.name} ($nickname)", this.favoriteMovie)
        def unary_! : String = s"$name, what the heck?!"
        def isAlive: Boolean = true
        def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
        def apply(num: Int): String = s"$name watched $favoriteMovie $num times"
        def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
        def learns(subject: String): String = s"$name learns $subject"
        def learnsScala() : String = this learns "Scala"
    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(mary likes "Inception") // equivalent
    // infix notation = operator notation

    // "Operators in Scala"
    val tom = new Person("Tom", "Fight Club")
    println(mary + tom)
    println(mary.+(tom))

    println(1+2)
    println(1.+(2))

    // ALL OPERATORS ARE METHODS

    // prefix notation
    val x = -1
    val y = 1.unary_-
    // unary_ prefix only works with - + ~ !
    println(!mary)
    println(mary.unary_!)

    // postfix notation
    println(mary.isAlive)
    println(mary isAlive)

    // apply
    println(mary.apply())
    println(mary()) // same effect
    // Object used as function, compiler searches for apply method.


    // 1. Overload the + operator : mary + "the rockstar" => new person "Mary (the rockstar)"
    println((mary + "the rockstar")())
    // 2. Add an age to person class, adds a Unary + operator new person with age + 1
    //   +mary => mary with the age incremented
    val newMary = new Person("Mary", "Inception", 23)
    println(newMary.age)
    println((+newMary).age)
    // 3. Add a "learns" method in the person class => "Mary learns scala"
    // Add a learnsScala method, calls learns method with "Scala"
    // Use it in postfix notation
    println(mary learnsScala)

    // 4. Overload Apply Method to receive a number.
    // mary.apply(2) => "Mary watched Inception 2 times"
    mary(2)
}
