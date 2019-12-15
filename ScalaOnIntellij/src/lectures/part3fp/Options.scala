package lectures.part3fp

import scala.util.Random

object Options extends  App{
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // Working with Unsafe APIs
  def unsafeMethod(): String = null
//  val result = Some(unsafeMethod) // Wrong
  val result = Option(unsafeMethod())
  println(result)

  // chained methods
  def backupMethod(): String = "A Valid Result"
  val chainedRes = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("Valid Result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - DO NOT USE THIS

  // map, flatmap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehensions
  /* Exercise

   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  println(config)

  class Connection {
    def connect = "Connected" // Connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] = {
      if(random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  val host = config.get("host")
  val port = config.get("port")
  /*
     If (h != null)
       if (p != null)
          return Connection.apply(h,p)
     return null
   */
  val conn = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  /*
    if c != null
      c.connect
    return null
   */
  val connectionStatus = conn.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // Chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val connStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  connStatus.foreach(println)
}
