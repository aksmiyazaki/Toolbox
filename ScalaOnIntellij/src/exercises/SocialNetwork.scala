package exercises

case class SocialNetwork(val people: Map[String, List[String]] = Map()) {

  def +(personName: String): SocialNetwork = {
    new SocialNetwork(people + (personName -> List()))
  }

  private def addWithList(personName: String, friendList: List[String] = List()): SocialNetwork = {
    new SocialNetwork(people + (personName -> friendList))
  }

  def -(personName: String): SocialNetwork = {
    def auxRemoveFromFriendList(curLst: List[String], networkAcc:Map[String, List[String]]): Map[String, List[String]] = {
      if(curLst.isEmpty) networkAcc
      else auxRemoveFromFriendList(curLst.tail, removeFriend(personName, curLst.head).people)
    }

    val unfriended = auxRemoveFromFriendList(people(personName), people)
    SocialNetwork(unfriended - personName)
  }

  def addFriend(p1: String, p2: String): SocialNetwork = {
    if(people.contains(p1) && people.contains(p2)) {
      val tmp1 = people(p1) :+ p2
      val tmp2 = people(p2) :+ p1
      this.addWithList(p1, tmp1).addWithList(p2, tmp2)
    } else this
  }

  def removeFriend(p1: String, p2: String) : SocialNetwork = {
    if(people.contains(p1) && people.contains(p2)) {
      val tmp1 = people(p1).filter(_ != p2)
      val tmp2 = people(p2).filter(_ != p1)
      this.addWithList(p1, tmp1).addWithList(p2, tmp2)
    } else this
  }

  def getFriendNo(p: String): Int = {
    if(people.contains(p)) people(p).length
    else throw new NoSuchElementException(s"Can't find element $p")
  }

  def mostPopPerson(): String = {
    people.maxBy(x => x._2.length)._1
  }

  def unpopularPeople(): Int = {
    people.count(_._2.isEmpty)
  }

  def isConnected(p1: String, p2: String) : Boolean = {
    def bfs(target: String, consideredPeople: List[String], discoverPeople: List[String]): Boolean = {
      if (discoverPeople.isEmpty) false
      else {
        val person = discoverPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoverPeople.tail)
        else bfs(target, consideredPeople :+ person, discoverPeople.tail ++ people(person))
      }
    }

    bfs(p2, List(), people(p1) :+ p1)
  }
}

object TestSocialNet extends App {
  val sn = new SocialNetwork()
  println(sn)

  val sn2 = (((((sn + "José") + "John") + "Joe") + "Linda") + "Zoe")
  println(sn2)

  val sn3 = sn2.addFriend("Linda", "Zoe").addFriend("Zoe" , "José")
  println(sn3)

  println(sn3.removeFriend("Linda" , "Zoe"))
  println(sn3)

  println(sn3.getFriendNo("Zoe"))
  println(sn3.mostPopPerson)
  println(sn3.unpopularPeople())
  println(sn3.removeFriend("José", "Zoe"))
  println(sn3.removeFriend("José", "Zoe").unpopularPeople())
  println(sn3)
  println(sn3 - "Linda")

  println(sn3.isConnected("José", "Linda"))
  println(sn3.isConnected("José", "Joe"))
}
