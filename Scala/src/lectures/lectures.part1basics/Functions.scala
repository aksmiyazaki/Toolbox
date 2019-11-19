package lectures.part1basics

object Functions extends App{
    def aFunction(a: String, b: Int): String = {
        a + " " + b
    }

    println(aFunction("Hello", 3))

    def aParameterlessFunction(): Int = 42
    println(aParameterlessFunction)

    def aRepeatedFunction(aString: String, n: Int): String = {
        if(n == 1) aString
        else aString + aRepeatedFunction(aString, n-1)
    }

    println(aRepeatedFunction("Hello", 3))
    // When you need loops, use recursion.

    def aFunctionWithSideEffects(aString: String) : Unit = {
        println(aString)
    }


    def aBigFunction(n: Int): Int = {
        def aSmallerFunction(a: Int, b: Int): Int = a + b

        aSmallerFunction(n, n-1)
    }

    /*
        1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
        2. Factorial
        3. Fibonacci
        4. Tests if a number is prime.
    */

    def greetingFunction(name: String, age: Int): String = {
        return "Hi, my name is " + name + " and I am " + age + " years old."
    }

    println(greetingFunction("Alexandre", 30))

    def factorial(n: Int): Int = {
        if(n <= 0) 1
        else n * factorial(n-1)
    }

    println(factorial(5))

    def fibonacci(n: Int): Int = {
        if(n == 1 || n == 2) 1
        else fibonacci(n-1) + fibonacci(n-2)
    }

    println(fibonacci(20))

    def isPrime(n: Int):Boolean = {
        def auxPrime(limit: Int): Boolean = {
            if(limit == 1) true
            else (!((n % limit) == 0) && auxPrime(limit-1))
        }
        auxPrime(scala.math.sqrt(n).asInstanceOf[Int])
    }

    println(isPrime(37))
    println(isPrime(2003))
    println(isPrime(37 * 17))
}
