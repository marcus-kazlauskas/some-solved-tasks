import scala.annotation.tailrec
import scala.io.StdIn.{readInt, readLine}

object Task5 {
  /**
   * Задача про диапазон чисел (собеседование в Сбере)
   */
  def findRange(numbers: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def findRangeHelper(numbers: Array[Int],
                        target: Int,
                        sum: Int,
                        from: Int,
                        until: Int): Array[Int] = {
      if (sum == target)
        Array(from, until)
      else if (until < numbers.length) findRangeHelper(
        numbers,
        target,
        sum - numbers(from) + numbers(until),
        from + 1,
        until + 1)
      else if (until - from < numbers.length) findRangeHelper(
        numbers,
        target,
        numbers.take(until - from + 1).sum,
        0,
        until - from + 1)
      else
        Array(-1)
    }
    findRangeHelper(numbers, target, numbers(0), 0, 1)
  }

  def main(args: Array[String]): Unit = {
    val numbers = readLine().split(' ').map(_.toInt)
    val target = readInt()
    val foundRange = findRange(numbers, target)
    println(foundRange.mkString("", " ", ""))
  }
}
