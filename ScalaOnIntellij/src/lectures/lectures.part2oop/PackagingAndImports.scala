package lectures.lectures.part2oop

import lectures.part2oop.Writer
import playground.{Cinderell => Princess, PrinceWhatever}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {
  // Package members are acessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess

  // Fully Qualified name
//  val princess = new playground.Cinderell

  // packages are in hierarchy
  // matches folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceWhatever

  val date = new Date
//  val sqlDate = new java.sql.Date(2019,12,22)
  val sqlDate = new SqlDate(2019,12,22)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function, ...
  // scala.Predef - println, ???
}
