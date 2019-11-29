package lectures.part1basics

object ValuesVariablesTypes extends App {
    val x: Int = 42
    val y = 44
    // VALS ARE IMMUTABLE
    // Compiler can infer types
    println(x)
    println(y)

    val aString: String = "Hello, this is a string"
    val anotherString = "Goodbye"

    val aBoolean: Boolean = true // false
    val aChar: Char = 'a'
    val anInt: Int = x
    val aShort: Short = 4444
    val aLong: Long = 8989898988989L
    val aFlota: Float = 2.0f
    val aDouble: Double = 3.14

    ///////////////////// Variables ////////////////////////////
    var aVariable: Int = 4
    aVariable = 5
}
