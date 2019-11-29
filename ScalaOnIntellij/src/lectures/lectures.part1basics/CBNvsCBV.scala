package lectures.part1basics

object CBNvsCBV extends App {
    def calledByValue(x: Long): Unit = {
        println("By Value: " + x)
        println("By Value: " + x)
    }

    def calledByName(x: => Long): Unit = { // By name
        println("By Name: " + x) // Expression of parameter is evaluated every time it is used.
        println("By Name: " + x)
    }

    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int) = println(println(x))

    //printFirst(infinite(), 34) Stack overflow
    printFirst(34, infinite()) // program survives because infinite() is not evaluated (not used)

}
