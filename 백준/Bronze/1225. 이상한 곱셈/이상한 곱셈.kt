fun main() {
    val (a, b) = readln().split(' ').map { it.sumOf { c -> c.digitToInt() } }
    println(a.toLong() * b)
}