package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // Switch on steroids
  val random = new Random
  val x = random.nextInt(10)
  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ =>  Wildcard
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "IDK who I am"
  }
  println(greeting)

  /*
   1. Cases are matched in order.
   2. what if no cases match? MatchError
   3. What is the type of a pattern match expression? Lowest common ancestor of all cases
   4. PM works really well with case classes (ancestor sealed triggers warning on the compiler).
   */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal : Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the breed $someBreed breed")

  }

  // do not match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  trait Expr
  case class Number(val n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1:Expr, e2: Expr) extends Expr

  def formatExpr(e : Expr) : String = {
    e match {
      case Number(n) => n.toString
      case Sum(v1, v2) => s"${formatExpr(v1)} + ${formatExpr(v2)}"
      case Prod(v1, v2) => {
        def maybeShowParentheses(exp: Expr) = exp match {
          case Prod(_, _) => formatExpr(exp)
          case Number(_) => formatExpr(exp)
          case _ => "(" + formatExpr(exp) + ")"
        }
        maybeShowParentheses(v1) + " * " + maybeShowParentheses(v2)
      }
      case _ => "Unknown operation"
    }
  }

  println(formatExpr(Sum(Number(1),Number(2))))
  println(formatExpr(Prod(Number(1),Number(2))))
  println(formatExpr(Sum(Number(3),Sum(Number(1),Number(2)))))
  println(formatExpr(Prod(Sum(Number(3),Number(2)), Number(5))))

}
