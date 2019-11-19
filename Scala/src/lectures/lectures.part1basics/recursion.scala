package lecture.part1basics
import scala.annotation.tailrec // import needed to @tailrec

object  Recursion extends App{
    @tailrec def factorial(n: Int): Int = { // Fails, not tailrec
        if (n <= 1) 1
        else {
            println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
            val result = n * factorial(n-1)
            println("Computed factorial of " + n)
            result
        }
    }

    print(factorial(10))
    //print(factorial(5000)) // Stack overflow

    def anotherFactorial(n: Int): BigInt = {
        @tailrec def factHelper(x: Int, accum: BigInt):BigInt = { // @tailrec annotation fails compilation if the function is not tail recursive.
            if(x <= 1) accum
            else factHelper(x-1, x * accum) // TAIL RECURSION = RECURSIVE CALL AT LAST EXPRESSION
        }

        factHelper(n, 1)
    }
    println(anotherFactorial(5000))


    /*
        1. Concatenate a string n times
        2. IsPrime Function
        3. Fibonacci function
    */

    // 1
    def Concat(tgt: String, n: Int): String = {
        @tailrec def auxConcat(tgt:String, x:Int, accum:String):String = {
            if(x == 0) accum
            else auxConcat(tgt, x-1, accum + tgt)
        }
        auxConcat(tgt, n, "")
    }

    Concat("potato", 5000)

    // 2
    def IsPrime(num:Int):Boolean = {
        @tailrec def auxPrime(tgt: Int, upTo:Int, accum:Boolean): Boolean = {
            if(upTo <= 1) (accum && true)
            else auxPrime(tgt, upTo - 1, (accum && (tgt % upTo != 0)))
        }
        auxPrime(num, scala.math.sqrt(num).asInstanceOf[Int], true)
    }

    IsPrime(2003)
    IsPrime(629)

    // 3
    def Fib(num: Int): Int = {
        @tailrec def auxFib(i: Int, accum:Int, accum2:Int): Int = {
            if(i >= num) accum
            else auxFib(i+1, accum + accum2, accum)
        }
        if(num <= 2) 1
        else auxFib(2, 1, 1)
    }

    Fib(1)
    Fib(2)
    Fib(3)
    Fib(8)
}
