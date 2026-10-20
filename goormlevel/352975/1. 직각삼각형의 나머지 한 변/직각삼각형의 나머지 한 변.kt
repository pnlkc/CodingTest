fun main() {
    val (a, b, c) = readLine()!!.trim().split(" ").map { it.toInt() }
    
    println(
        when {
            a == -1 -> c * c - b * b
            b == -1 -> c * c - a * a
            else -> a * a + b * b
        }
    )
}