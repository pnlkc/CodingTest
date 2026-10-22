fun main() {
    val (a, b, q) = readLine()!!.split(" ").map { it.toInt() }
    var result = 0
    
    for (i in 1..q) {
        result += if (i % 2 == 0) -b else a
    }
    
    println(result)
}