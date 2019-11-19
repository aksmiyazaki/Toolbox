package lectures.part1basics

object Expressions extends App {
    val x = 1 + 2 // Expression
    print(x)

    println(2 + 3 * 4)
    // + - * / & | ^ << >> >>> (right shift with zero extension)

    println(1 == x)

    println(!(1 == x))
    // ! && ||

    var aVariable = 2
    aVariable += 3
    println(aVariable)

    // Instructions (DO) vs Expressions (VALUE)
    // IF expression
    val aCondition = true

    val aConditionedValue = if(aCondition) 5 else 3 // if expression, returns a value
    println(aConditionedValue)

    println("Printing 1 to 10")
    var i = 0
    while (i < 10){
        println(i)
        i += 1
    }
    // Avoid this kind of loops
    // Everything in Scala is an Expression

    val aWeirdValue = (aVariable = 3) // Unit == Void
    println(aWeirdValue)

    // side effects : println(), whiles, reassigning
    ///////// code blocks

    val aCodeBlock = {
        val y = 2
        val z = y + 1

        if (z > 2) "Hello" else "GoodBye" // result of the last expression is the result of the block.
    }

    //1. Diff btw "Hello World" and println("Hello world")?
    // One is evaluated other is executed
    // 2
    val someValue = {
        2 < 3
    }

    // R: Type of expression is boolean.

    //3
    val someOtherValue = {
        if(someValue) 239 else 986
        42
    }
    println(someOtherValue)
    // res is 42 and type is int
    // Side Effect returns Unit.
}
