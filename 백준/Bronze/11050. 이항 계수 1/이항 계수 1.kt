fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val top = (n - k + 1..n).fold(1) { acc, i -> acc * i }
    val bottom = (1..k).fold(1) { acc, i -> acc * i }
    println(top / bottom)
}