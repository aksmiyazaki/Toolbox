package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String for you")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax Sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // Utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String= "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // If you design the API
  def betterUnsafeMethod() : Try[String] = Failure(new RuntimeException)
  def betterBackupMethod() : Try[String] = Success("A valid Result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatmap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  // for comprehensions
  /*
    Execise
   */

  println("Starting Exercise")
  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection{
    def get(url: String) : String = {
      val rand = new Random(System.nanoTime())
      if (rand.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }


  }

  object HttpService{
    val rand = new Random(System.nanoTime())
    def getConnection(host: String, port: String) : Connection =
      if (rand.nextBoolean()) new Connection()
      else throw new RuntimeException("Someone else took the port")
  }

  println("Long solution")
  val possibleConnection = Try(HttpService.getConnection(hostname, port))
  val possibleHtml = possibleConnection.flatMap(x => Try(x.get("potato.com")))
  possibleHtml.foreach(renderHTML)

  println("Short solution")
  Try(HttpService.getConnection(hostname,port))
    .flatMap(x => Try(x.get("portato.com")))
    .foreach(renderHTML)

  println("For comprehension solution")
  // if get the html from the connection, print it ot the console (call renderHTML)
  for {
    c1 <- Try(HttpService.getConnection(hostname, port))
    c2 <- Try(c1.get("potato.com"))
  } renderHTML(c2)

}
