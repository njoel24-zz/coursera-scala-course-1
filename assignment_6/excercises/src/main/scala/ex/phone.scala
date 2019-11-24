object x {

	val in = Source.fromUrl("")
	val words = in.getLines.toList filter (word => word forall (char => chr.isLetter))

	val mnem = Map ('2' -> "ABC",'3' -> "DEF",'4' -> "GHI",'5' -> "JKL",'6' -> "MNO",'7' -> "PQR",'8' -> "STU",'9' -> "XYZ")

	val charCode: Map[Char, Char] = // two generators
		for((digit, str) <- mnem; ltr <- str ) yeald ltr -> digit

	def wordCode(word: String): String = word map charCode

	val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()

	def encode(number: String): Set[List[String]] = 
	if(number.isEmpty) Set(List())
	else {
		for {
			split <- 1 to number.length
			word <- wordsForNum(number take split)
			rest <- encode(number drop split)
		} yield word :: rest
	}

	def translate(number: String): Set[String] = encode number map ( _ mkString " ")
}

object y {

	 def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys => 
      val (first, rest) = xs span (x => y == x)
      first :: pack(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.lenght ))


    def isPrime(n: Int) : Boolean = {
      def g(n: Int, m: Int): Boolean = n match {
        case 1 => true
        case > 1 => if((n % m) == 0) false else g(n, m-1)
      }

      g(n, n-1)
    }

    def isPrime(n:Int): Boolean = 2 until n forall(d => n % d != 0)

    object pairs = {
      val n = 7
      (1 until n ) flatMap (i => (1 until i) map(j => (i, j) ))
      filter (x => isPrime(x._1 + x._2))
    }

    def pairs = {
      for {
      i <- 1 until n
      j <- 1 until i
      if(isPrime(i+j))
    } yeald (i, j)
  }

  // for(p <- persons if p.age > 20 ) yeld p.name eqiuivalent to:
  // persons filter (p => p.age > 20) map ( p => p.name)

  def scalarProduct(xs: List[Double], ys: List[Double]): Double = 
  (for((x, y) <- xs zip ys) yeld x * y).sum


// excercise on Set
  // List(0,3,1) -> List((2,0),(1,3),(2,1))
  object nqueens {
    def queens (n: Int): Set[List[Int]] = {
      def placeQueens(k: Int): Set[List[Int]] = 
        if(k == 0) Set[List()]
        else
          for {
            queens <- placeQueens(k - 1)
            col <- 0 until n
            if(isSafe(col, queens))
            } yeld col :: queens
      placeQueens(n)
          }
    }
    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.lenght
      val queensWithRow = (row -1 until 0 by -1) zip queens 
      queensWithRow forall {
        case (r,c) => col != c && math.abs(col-c) != row-r
      }
    }
  }

  def show(queens: List[Int]) = {
    val lines = for (col <- queens.reverse)
    yeld Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  }

  (queens(4) take 3 map show) mkString "\n"



object polynomianals {

  class Poly(val term0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def adjust(term: (Int, Double)): Map[Int, Double] =
      val (exp, coeff) = term
      exp -> (coeff + terms(exp)) // bindings
  }
  override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yeld coeff+"x^"+exp) mkstring " + "
}


}

// attributi predefinit per mappe, significato di :+ and ->
// this version avoids the creation of an intermediate structure that was concatenated to the terms
object polynomianalsFoldLeft {

  class Poly(val term0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    def + (other: Poly) = new Poly(other.terms foldLeft terms)(addTerm)
    def addTerm(terms: Map[Int, Double], term: (Int, Double)) = { // term is taken from other.terms
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp))) // bindings   
    }
  override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yeld coeff+"x^"+exp) mkstring " + "
}

}