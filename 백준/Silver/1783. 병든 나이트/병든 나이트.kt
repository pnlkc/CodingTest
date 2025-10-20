fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val result = when (N) {
        1 -> 1
        2 -> minOf(4, (M + 1) / 2)
        else -> if (M < 7) minOf(4, M) else 1 + 4 + (M - 7)
    }

    println(result)
}