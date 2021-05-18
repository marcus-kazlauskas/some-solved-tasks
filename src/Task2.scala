import scala.annotation.tailrec
import scala.collection.immutable.HashMap
import scala.io.StdIn.readLine

object Task2 {
  /**
   * Задача про красивые имена (стажировка в Тинькофф, №2)
   */
  val letter: HashMap[Char, Boolean] = HashMap(
    'q'-> false,
    'w'-> false,
    'e'-> true,
    'r'-> false,
    't'-> false,
    'y'-> true,
    'u'-> true,
    'i'-> true,
    'o'-> true,
    'p'-> false,

    'a'-> true,
    's'-> false,
    'd'-> false,
    'f'-> false,
    'g'-> false,
    'h'-> false,
    'j'-> false,
    'k'-> false,
    'l'-> false,

    'z'-> false,
    'x'-> false,
    'c'-> false,
    'v'-> false,
    'b'-> false,
    'n'-> false,
    'm'-> false
  )

  def checkVowel(l: Char): Boolean = Task2.letter.getOrElse(l, false)

  @tailrec
  def checkName(name: String, first: Boolean, i: Int = 1, pretty: Boolean = true): Boolean =
    if (!pretty || i == name.length)
      pretty
    else if (first)
      if (i % 2 == 0) checkName(name, first, i + 1, checkVowel(name(i)))
      else checkName(name, first, i + 1, !checkVowel(name(i)))
    else
      if (i % 2 == 0) checkName(name, first, i + 1, !checkVowel(name(i)))
      else checkName(name, first, i + 1, checkVowel(name(i)))


  def main(args: Array[String]): Unit = {
    val name = readLine()
    val pretty = checkName(name, checkVowel(name(0)))
    if (pretty) println("YES") else println("NO")
  }
}
