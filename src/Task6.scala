import scala.annotation.tailrec
import scala.io.StdIn.{readInt, readLine}
import scala.util.Sorting.quickSort

object Task6 {
  /**
   * Задача про любителей пиццы (стажировка в Тинькофф, №6)
   */
  def countTime(n: Int, personTime: Array[Int]): Int = {
    @tailrec
    def countTimeHelper(n: Int,
                        personTime: Array[Int],
                        personCount: Array[Int],
                        index: Int,
                        time: Int,
                        maxIndex: Int,
                        maxTime: Int): Int = {
      if (n == 0)
        time
      else if (personCount(index) + personTime(index) <= maxTime) {
        personCount(index) += personTime(index)
        countTimeHelper(
          n - 1,
          personTime,
          personCount,
          index,
          personCount(index),
          maxIndex,
          maxTime
        )
      } else if (index < maxIndex)
        countTimeHelper(
          n,
          personTime,
          personCount,
          index + 1,
          time,
          maxIndex,
          maxTime
        )
      else if (maxIndex < personTime.length - 1)
        countTimeHelper(
          n,
          personTime,
          personCount,
          0,
          time,
          maxIndex + 1,
          personCount(maxIndex + 1) + personTime(maxIndex + 1)
        )
      else
        countTimeHelper(
          n,
          personTime,
          personCount,
          0,
          time,
          1,
          personCount(1) + personTime(1)
        )
    }

    val personCount = new Array[Int](personTime.length)
    for (i <- personCount.indices) {
      personCount(i) = 0
    }

    if (personTime.length == 1)
      n * personTime(0)
    else
      countTimeHelper(n, personTime, personCount, 0, 0, 1, personCount(1) + personTime(1))
  }

  def main(args: Array[String]): Unit = {
    val taskParam = readLine().split(' ').take(2).map(_.toInt)
    val n = taskParam(0)
    val m = taskParam(1)
    val personTime = new Array[Int](m)
    for (i <- 0 until m) {
      personTime(i) = readInt()
    }
    quickSort(personTime)

    val time = countTime(n, personTime)
    println(time)
  }
}
