 object Sqr {
 	def isGoodEnough(x: Double, y: Double): Boolean = { 
		var diff = abs((x-(y*y)))/x
		println("y:"+y+" - diff: "+diff+"\n")
		if(diff<= 0.0001) true else false }

 	def sqrIter(x: Double, y: Double, round: Int): Double = if(isGoodEnough(x, y)) y else { 
 		sqrIter(x,improve(x,y), newRound(round))
 		}

    def newRound(round: Int): Int = { 
    	println(round)
    	round+1
    }

 	def improve(x: Double, y: Double): Double = ((x/y) + y)/2

	def abs(x:Double):Double = if(x >= 0.00) x else -x

	println("1")
 	def sqrt(x: Double): Double = sqrIter(x,1.00,2);

}