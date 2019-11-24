/* abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}*/



/* class Empty() extends IntSet  {
	def incl(x: Int): IntSet = new NoEmpty(x, new Empty(), new Empty()) 
  	def contains(x: Int): Boolean = false
  	def union(other: IntSet): IntSet = other
}

class NoEmpty(elem: Int, left: Empty, right: Empty)  {
	def incl(x: Int): IntSet = if(x < elem) new NoEmpty(elem, left incl x, right) 
	// else if new NoEmpty(x, left, right incl x) else this
	// def contains(x: Int): Boolean = if(x > elem ) right contains x  else if right contains x else true
  	// def contains(x: Int): Boolean = if(x > elem ) this.right.contains(x)  else if this.left.contains(x) else true
  	override def toString = "{" + left elem right + "}"
  	//def union(other: IntSet): IntSet = if(other elem >= elem) new NoEmpty(0, this, other ) else new NoEmpty(0, other, this)
  	// def union(other: IntSet): IntSet = ((left.union(right)).union(other)).incl(elem)
  	// def union(other: IntSet): IntSet = ((left union right) union other) incl elem

}*/


import java.util.NoSuchElementException
import java.lang.IndexOutOfBoundsException

trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

// note that we have head as a val , it is already a property of the class
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
	def isEmpty = false
}

class Nil[T] extends List[T] {
	def isEmpty: Boolean = true
	def head: Nothing = throw new NoSuchElementException("Nil.Head")
	def tail: Nothing = throw new NoSuchElementException("Nil.Tail")
}

// List can have two forms as subtypes. Each subtypes can have different signatures(generics)

// example with Null, Nothing and String to test the hierarchy

object Main {

def getNthElementFromList[T](nth: Int, list: List[T]): T =  {
	if(nth<0) throw new IndexOutOfBoundsException("not a valid index")
	else return search(0, list);

	def search(tmpIndex: Int, list: List[T]): T = {
		if(list isEmpty) return throw new IndexOutOfBoundsException("empty list")
		else if(tmpIndex == nth) list head 
		
		else  search(tmpIndex+1, list tail)
}
	throw new NoSuchElementException("Nil.Tail")
}

// def singleton[T](elem: Int) = new Cons[T](elem, new Nil[T])


	def main(args: Array[String]): Unit = {
		println("hello world");

		println(getNthElementFromList(0,new Cons(1, new Cons(2, new Cons(3, new Nil())))))

	}

}