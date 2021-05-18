import scala.io.StdIn.readLine

object Task3 {
  /**
   * Задача про время (стажировка в Тинькофф, №3)
   */
  def main(args: Array[String]): Unit = {
    val timeParam = readLine().split(' ').map(_.toInt).take(4)
    // println(timeParam.mkString("numbers = ", " ", ""))
    val a = timeParam(0)
    val b = timeParam(1)
    val c = timeParam(2)
    val t = timeParam(3)
    var time = t % (a * b * c)
    val h = (time / (b * c)).floor.toInt
    time = time % (b * c)
    val m = (time / c).floor.toInt
    val s = time % c
    println(s"$h $m $s")
  }
}
