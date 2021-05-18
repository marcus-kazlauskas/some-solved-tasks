import scala.io.StdIn.readLine

object Task1 {
  /**
   * Задача про домиошки (стажировка в Тинькофф, №1)
   */
  def main(args: Array[String]): Unit = {
    val domino_1 = readLine().split(' ').map(_.toInt)
    val domino_2 = readLine().split(' ').map(_.toInt)
    val cross = (domino_1.toSet & domino_2.toSet).toArray
    if (cross.isEmpty)
      println(-1)
    else if (cross.length == 1) {
      val a = if (domino_1(0) == cross(0)) domino_1(1) else domino_1(0)
      val b = if (domino_2(0) == cross(0)) domino_2(1) else domino_2(0)
      println(s"$a ${cross(0)} ${cross(0)} $b")
    }
    else if (cross.length == 2) {
      println(cross.mkString("", " ", "") + " " + cross.reverse.mkString("", " ", ""))
    }
  }
}
