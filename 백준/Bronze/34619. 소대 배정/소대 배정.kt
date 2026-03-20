fun main() {
    val (a, b, n, k) = readln().split(" ").map { it.toInt() }

    val f = (k - 1) / (n * b) + 1
    val s = (k - 1) % (n * b) / n + 1

    println("$f $s")
}