fun main() {
    val aSum = readln().split(" ").sumOf { it.toInt() }
    val bSum = readln().split(" ").sumOf { it.toInt() }
    println(maxOf(aSum, bSum))
}