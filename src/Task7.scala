import scala.math.pow
import scala.annotation.tailrec
import scala.io.StdIn.readInt

object Task7 {
  /**
   * Задача про рекурсивное дерево (взято с HackerRank)
   */
  def getLine(n: Int, m: Int, i: Int): String = {
    if (n > 0)
      if (i < m)
        ("_" * (m * 2)) + "1" + ("_" * (m * 2 - 1))
      else if (i < m * 2)
        ("_" * (m * 3 - (i + 1))) + "1" + ("_" * ((i - m) * 2 + 1)) + "1" + ("_" * (m * 3 - (i + 2)))
      else if (m > 1)
        getLine(n - 1, m / 2, i - (m * 2)) * 2
      else
        getLine(n - 1, 1, 0)
    else
      "_" * (m * 4)
  }

  @tailrec
  def getTree(n: Int, i: Int = 0, tree: List[String] = List()): List[String] = {
    if (i == 63)
      tree
    else
      getTree(n, i + 1, ("_" * 17 + getLine(n, 16, i) + "_" * 19) :: tree)
  }

  def main(args: Array[String]): Unit = {
    print(getTree(readInt()).mkString("", "\n", ""))  // должно быть без лишних символов!
  }
}
