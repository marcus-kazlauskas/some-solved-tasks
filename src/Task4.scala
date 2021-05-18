import scala.annotation.tailrec
import scala.collection.immutable.List
import scala.io.StdIn.readLine

object Task4 {
  /**
   * Задача про смайлики (собеседование в Яндексе)
   */
  @tailrec
  def cutSmile(phrase: String,
               i: Int = 0,
               count: Int = 0,
               bracket: Char = ' ',
               from: Int = 0,
               parts: List[String] = List()): List[String] = {
    if (i == phrase.length)
      if (count > 2)
        phrase.slice(from, i - count) :: parts
      else
        phrase.slice(from, i) :: parts
    else
      if ((count == 0 && phrase(i) == ':') || (count == 1 && phrase(i) == '-'))
        cutSmile(phrase, i + 1, count + 1, bracket, from, parts)
      else if (count == 2 && (phrase(i) == '(' || phrase(i) == ')'))
        cutSmile(phrase, i + 1, count + 1, phrase(i), from, parts)
      else if (count > 2 && (phrase(i) == bracket))
        cutSmile(phrase, i + 1, count + 1, bracket, from, parts)
      else if (count > 2 && (phrase(i) != bracket))
        cutSmile(phrase, i + 1, 0, ' ', i, phrase.slice(from, i - count) :: parts)
      else
        cutSmile(phrase, i + 1, 0, ' ', from, parts)
  }

  def main(args: Array[String]): Unit = {
    val phrase = readLine()
    val cleanPhrase = cutSmile(phrase)
    println(cleanPhrase.reverse.mkString("", "", ""))
  }
}
