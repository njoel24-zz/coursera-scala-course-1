package idealize.types

/* abstract class Boolean {

	def ifThenElse[T](t: => T, e: => T): T

	def && (x: => Boolean): Boolean = ifThenElse(x, false)
	def || (x: => Boolean): Boolean = ifThenElse(true, x)
	def unary_! : Boolean = ifThenElse(false, true)
	def == (x: => Boolean): Boolean = ifThenElse(x, x.unary_!)
	def != (x: => Boolean): Boolean = ifThenElse(x.unary_!, x)
	def < (x: => Boolean): Boolean = ifThenElse(false,x) // assuming false < true

}*/

/* object true extends Boolean {
	def ifThenElse[T](t: => T, e: => T) = t
}


object false extends Boolean {
	def ifThenElse[T](t: => T, e: => T) = e
} */

// Peano number
/* abstract class Nat {
  def isZero: Boolean = if(Zero) true else false
  def predecessor: Nat
  def successor: Nat = new Succ(this);
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
	def isZero: Boolean = true
  	def predecessor: Nat = throw new Error("0 can't have predecessor")
  	def + (that: Nat): Nat = that
  	def - (that: Nat): Nat = if (that.isZero) this else throw new Error("Error")
}

class Succ(n: Nat) extends Nat {
	def isZero: Boolean = false
  	def predecessor: Nat = n 
  	def + (that: Nat): Nat = new Succ(n + that)
  	def - (that: Nat): Nat = if(that.isZero) this else (n - that.predecessor)
}


trait function1[A, B] {
	def apply(x: A): B
}*/

/* abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty() extends IntSet  {
	def incl(x: Int): IntSet = new NoEmpty(x, new Empty(), new Empty()) 
  	def contains(x: Int): Boolean = false
  	def union(other: IntSet): IntSet = other
}

class NoEmpty(elem: Int, left: Empty, right: Empty) extends IntSet  {
}
*/

/* trait List[+T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List {
	def isEmpty: false
}

object Nil extends List[Nothing] {
	def isEmpty = true
	def head: Nothing = throw new NoSuchElementException("Nil.head")
	def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object test {
	val a: List[String] = Nil
}

def show(e: Expr): String = e match {
	case Number(n): toString(n)
	case Sum(a, b): toString(a)+toString(b)
}
*/


object Main extends App {

	def isort(xs: List[Int]): List[Int] = xs match {
		case List() => List()
		case y :: ys => insert2(y, isort(ys))
	}



	/* def insert(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => if(x > y) insert(y, x ::ys) else insert(x, ys)
	} */


	def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => if(x <= y) x :: xs else y :: insert2(x, ys)
	}
	
	/* val a: Array[NoEmpty] = Array(new NoEmpty(1, new Empty(), new Empty()))
	val b: Array[IntSet] = a
	b(0) = new Empty()
	val s: NoEmpty = a(0) */

	def l: List[Int] = List(2,5,1,5,3,2,5,7,134,68,4)
	println(isort(l))
}


