package recfun
import scala.util.matching.Regex
object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    if(balance("(if (zero? x) max (/ 1 x))".toList)) println("balanced") else println("not balanced");
    println(countChange(2,List(1,2)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =  { 

      if(r == 0 || r == 1)  return 1

      if(c == 0 || c == r)  return 1

      pascal(c-1, r-1) + pascal(c,r-1)
      
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def getParenthesis(chars: List[Char]): List[Char] = {
        val regex = "[()]".r
        return chars filter (x => regex.pattern.matcher(x.toString).matches)
      }

      def isOdd(chars: List[Char]): Boolean = {
        if(chars.length % 2 == 0) return false else return true
      }

      def balanced(chars: List[Char], o: Int): Boolean = {
        if(chars.isEmpty) return o == 0
        if(chars.head == '(') return balanced(chars.tail, o+1)
        if(chars.head == ')' && o <= 0) false else return balanced(chars.tail, o-1)
      }      

      if(getParenthesis(chars).isEmpty) return true

      if(isOdd(getParenthesis(chars))) return false
      return balanced(getParenthesis(chars), 0);          
    }
  
    def countChange(money: Int, coins: List[Int]): Int = {
      def cc(a: Int, l: List[Int]): Int = {
        if (a == 0) 1
        else if (a < 0 || l.isEmpty) 0
        else cc(a - l.head, l) + cc(a, l.tail)
      }
      cc(money, coins)
    } 

  }
