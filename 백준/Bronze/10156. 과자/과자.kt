fun main() {
    val (k, n, m) = readln().split(" ").map { it.toInt() }

    println(maxOf(0, k * n - m))
}