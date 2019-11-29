package lectures.part1basics
import scala.annotation.tailrec // import needed to @tailrec

object DefaultArgs extends App {

    @tailrec def tailRecFactorial(n: Int, acc:Int = 1): Int = {
        if(n <= 1) acc
        else tailRecFactorial(n-1, n*acc)
    }

    val Fact10 = tailRecFactorial(10)

    def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving Picture")

    //savePicture()
    // Name the arguments or pass parameters in order.
    savePicture(width = 800)
}
