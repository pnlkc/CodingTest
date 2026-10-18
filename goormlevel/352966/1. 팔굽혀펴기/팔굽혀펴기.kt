fun main(args: Array<String>) {
	val (x, s) = readLine()!!.split(" ").map { it.toInt() }
		
	print(x * s)
}