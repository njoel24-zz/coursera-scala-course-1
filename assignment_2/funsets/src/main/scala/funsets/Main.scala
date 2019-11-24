 package funsets

object Main extends App {
  import FunSets._
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s4 = singletonSet(4)
  val s5 = singletonSet(5)
  val s6 = singletonSet(6)
  val s = union(s1, s2)
  val t = union (s3, s4)
  val u = union (s5, s6)
  def p = (x: Int) => (x % 2) == 0
  def q = (i : Int) => i*10
  def evenGroup = union(s2,s4)
  def oddGroup = union(s1,s3)
  def mixGroup = union(s1,s2)
  val group = union(union(union(s1,s2),union(s3,s4)), union(s5,s6))
  
  printSet(map(mixGroup, q))
} 


/*
object Main extends App {

// The type of this function is (Int => Int)(Int, Int) => Int
// The function defined internally is the core of the sum function. 

def sum(f: Int => Int)(a: Int, b: Int): Int = {

	def loop(a: Int, acc: Int): Int = {
		if(a>b) acc
		else loop(a+1, f(a)+acc)
	}
	loop(a,0)
}

def product(f: Int => Int)(a: Int, b: Int): Int = {

	def loop(a: Int, acc: Int): Int = {
		if(a>b) acc
		else loop(a+1, f(a)*acc)
	}
	loop(a,1)
}

def product(f: )

def op(f: Int => Int)(a: Int, b: Int, startValue: Int): Int = {

	def loop(a: Int, acc: Int): Int = {
		if(a>b) startValue
		else loop(a+1, f(a,acc))
	}
	loop(a,startValue)
}

println(op((x,y) => x*y, 1,5,1))
println(op((x, y) => x+y, 1,5,1))



def factorial(f: Int => Int)(a: Int): Int = {

	def loop(a: Int, acc: Int): Int = {
		if(a==0) 1
		else loop(a-1, f(a)*acc)
	}
	loop(a,1)
}

// println(product(x => x)(1,9))

}

*/

