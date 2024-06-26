fun main() {
    val T = readln().toInt()
        
    for (tc in 1..T) {
        val (a, b) = readln().split(",").map { it.toInt() }
        println(a + b)
    }
}