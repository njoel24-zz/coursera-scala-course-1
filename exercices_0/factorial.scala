object Factorial {
	
	def factorial(n: Double, r: Double): Double = 
		if(n==0) r else  factorial(n-1, n*r)

}