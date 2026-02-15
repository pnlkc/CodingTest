fun main() {
    val n = readln().toInt()

    println(if (n.toLong() * n > 100_000_000) "Time limit exceeded" else "Accepted")
}