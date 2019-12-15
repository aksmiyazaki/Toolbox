//package exercises
//import scala.annotation.tailrec
//
//object Test extends App {
//    abstract class MyList[A]() {
//        var next : Option[MyList[A]] = None
//        var curVal : Option[A] = None
//
//        def head : Option[A] = {
//            if(curVal.isDefined) this.curVal
//            else None
//        }
//
//        def isEmpty : Boolean = {
//            this.curVal.isEmpty
//        }
//
//        def tail : Option[A] = {
//            @tailrec  def auxTail(cur : MyList[A]) : MyList[A] = {
//                if(cur.next == None) cur
//                else auxTail(cur.next.get)
//            }
//
//            if(this.curVal.isDefined){
//                if(this.next == None) this.curVal
//                else auxTail(this).curVal
//            }
//            else None
//        }
//
//        def add(newValue : A) : Unit
//
//        override def toString : String = {
//            @tailrec def auxToString(curV:MyList[A], acumulator:String="") : String = {
//                if(curV.next == None) s"${if(acumulator.length > 0) acumulator + ", " else ""}${curV.curVal.get}"
//                else auxToString(curV.next.get, s"${if(acumulator.length > 0) acumulator + ", " else ""}${curV.curVal.get}")
//            }
//
//            if(this.isEmpty) s"[ ]"
//            else s"[ ${auxToString(this)} ]"
//        }
//    }
//
//    class ConcList[A]() extends MyList[A](){
//        override def add(newValue : A) : Unit = {
//            def auxAdd(curVal: ConcList[A]):Unit = {
//                if(curVal.next == None){
//                    curVal.next = Some(new ConcList[A]())
//                    curVal.next.get.curVal = Some(newValue)
//                }
//                else {
//                    auxAdd(curVal.next.get.asInstanceOf[ConcList[A]])
//                }
//            }
//
//            if(this.curVal.isEmpty) this.curVal = Some(newValue)
//            else auxAdd(this)
//        }
//    }
//
//
//    var test = new ConcList[Int]()
//    println(s"IsEmpty? : ${test.isEmpty}")
//    (0 to 100) foreach(x => test.add(x))
//    println(test.head)
//    println(test.tail)
//    println(test.toString())
//
//    var test2 = new ConcList[String]()
//    test2.add("potato")
//    test2.add("tomato")
//    test2.add("Onions")
//
//    println(test2.head)
//    println(test2.tail)
//    println(test2.toString())
//}
