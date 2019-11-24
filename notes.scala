// indentare, uso di object, comandi da sbt, create package, evitare exit and console again. Install the environment 
// on netbook
// round+1 struttura mutabile
//isGoodenough non funziona su numerim molto piccoli + grafico cartediano 
// build
// organize folders better
// grading policy
// found UNIt and ===
//  funzione dentro un blocco e ricorsione e ripetizione del blocco 
// avolte vule il return a volte no
// definizione della fuznione alla fine.
// '' and ""
// package object common 
// object as instances of class and object as  a block.
// val xs = for (i <- -bound to bound if contains(s, i)) yield i
// package.scala in second assignment.
// java collections?
// nothing null and unit
// :+ ++
// trasversable vs iterators
// :: :::
// nil and nothing

// NOTES ON FIRST AND SECOND WEEK

// If The type of this function is (Int => Int)(Int, Int) => Int we always associate to the right 
// that means (Int => Int)((Int, Int) => Int)
// The function defined internally is the core of the sum function. 
// pasaggio per riferimento o per valore per i tipi primitivi

/*

def sum(f: Int => Int)(a: Int, b: Int): Int = {

	def loop(a: Int, acc: Int): Int = {
		if(a>b) acc
		else loop(a+1, f(a)+acc)
	}
	loop(a,0)
}

println(sum(x => x)(1,9))

}

// quando usare objects, quando usare classes.


*/

// Tail Recursive functions is always a better solution than using Tail call functions. But...when we should use Tail call functions

// def means that that particular variable will be evalueted at each use. With val  we evalueted it at the time of definition.

// call-by-Name and call-by-value are two ways of evaluete an expression 

// anonymous function are using to use the concept of literals in the function context.

// dynamic scope (inner scope evalueted runtime) and static scope or lexical scope(inner scope inerited from the outer 
// scope and evalueted at compile time)

// a way to define a costructor is def this(x) = this(x,1)

// the type of the parameter in Scala can be omitted and deducted at runtime

// dot notation and infix notation r.add(z) or r add z

// the substitution model can be applied to class as we did already for expressions

// in Scala we can use special characters as identifiers like &%2?

// identifier = lexical like def c = "123"

// expressions, types, definitions, parameters

// currying is a mechanism used in higher order functions context.

// functions are first-class-values

// if CBV terminates -> CBN terminates . The opposite is not true. Scala uses CBV by default because it is  more performant
// You can use CBN by using =>

// REPL (Read/Eval/Print/loop) shell

// Scala is useful for Parallelism, Cloud Computing, multicore and modularity.

// EBNF as a way to express the sntax of a language, that can be context-free

// on the inside a class, the name this rapresent the object on which the current method is executed

// difference nbetween assert and require as preconditions


// notes week 3
// dynamic binding, fully qualified name,  
// you can import from a package or from an object
// preimported packages: java.lang, scala, scala.Predef	
// object are singleton ready to use classes. Can we say that an object is a static class?
// A class can only have a super class. A class can have several super types to which it conforms. Here
// we have  traits that  are abstact classes .
// a trait can't have valued parameters
// class A extends B with C with D Scala
// class A extends B implements C, D java
// C is a trait that is like an interface but a trait can have concrete methods
// subtype relantionship and conversion relanshionship(change of the byte rappresentation) 

// nothing is a subtype of the classes, like Null
// immutable linked list: Nil or a cell with a link to the next one
// Polimorfismo: Type parameterization means that classes as well as methods can now have types as parameters. 
// Type parameters are writte between square brackets [T]
// even functions can be polymorphics
// type erasure: type are not considered during evaluation
// polymorfism can be of two forms: generics or subtypes
// classes hierachy and evaluation



// notes on week 4
// => è un opearatore che prende un espression x: => Boolean
// it is possible to rapresent primitive data like boolean as classes
// functions are objects
// anonymous objects
// eta-expansion
// function types are related to classes, and function values are related to objects
// another two types of polymorphism: type bound and variance and covariance in addition to generics and subtypes
// typpe bounce example: S < NoEmpty . We talk about covariance in case we have collections and array 
// for example: List[NoEmpty] <: List[Empty] List are covariant and Array are not.
// List covariant and Array not? Becase List are immutable and Array are not.
// Liskov substitution : if A<:B then everything one can do with a value of type B one should also be able to do with a value of type A
// in scala array are not covariant, so there is no subtype relations beween them
// covariant, contravariant, novariant
// functions are contravariant in their argument type and covariant in their result type.
package scala
trait Function1[-T, +U] {
	def apply(x: T): U  // thiis rule helps avoiding mutability
}


// avoid type cast (isInstanceOf asInstanceof)

// Pattern matching is a good tool for developing decomposition

// decomposition techniques that does not work: classification and access methods, type test and cast , OO decomposition
// in pattern matching the variables are lower case and the constants are uppercase
// extensibility of two typw :  new methods , new classes. In the second case Pattern matching is a really ggod solution.

// lists are immutable and list are recursive structures
// lists are homogeneous, the elements of a list must have the same type.
// general convention regarding operators enfding in : where the associativty is set tot the right.
// :: === doppia tildeuna sopra l'altra
// patters matching in scala for lists


// notes on week 5
// prepend
// tuple type, tuple expression, tuple pattern
// Tuple2[t1, t2](_1: T1, _2: T2)
// val (label, value) = pair this is called pattern binding or
// val label= pair._1 
// suign of implicit modificator
//  patterns on functions regarding lists: transforming, retrieving and combining
// partition and other functions
// foldleft and foldright different applications
// structural inductions on lists
// referential transparency
// iterable -> seq, set, map
// seq->vector, list
// string and array can implicity be converted to sequences
// complexity of vector (log base 32 of N)
// insert a new element in a vector: the complexity is (log base 32 of N)
// vantaggi di utilizzare liste invece di vector
//  if your access patterns have this recursive structures, lists are better. If your access patterns are typically bulk operations, such as map or fold, or filter, then a vector would be preferable
// ranges
// shortcut of pattern matchig using just case
// indexSequence between range and sequence.
// method flatten: single sequence from a sequence of sequence, that is another way to say concat
// xs faltMap f = (xs map f).flatten

// sets do not have duplicates, sets do not have order and contains is the fundamental op.

// maps are iterable as they can be seen as pair . Therefore they are functions.
// u can use the get operator to avoid exceptions
// option is a datatype in scala
// Options supports some other operations from colleztions.
// sortWith, sorted and groupBy
// withDefaultValue transforms a map in perfect functions.

// scripting languages vs general purpose languages








// foldleft and fold right
// def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldLeft ys)(_ :: _)
 // println( 1 :: (4 :: Nil) ) // foldRight
 //println( ((1 :: Nil) :: 4) ) // foldLeft
 //println(Nil::4) // non va
 //println(4::Nil) // va


// algoritmo combinatorio usando matrici e matrici sparse e metodo turini
// permutazioni , disposizioni e combinazioni 
// for example, foldleft con for