fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val isPossible = BooleanArray(4)

    for (i in 1..K) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        var idx = 0

        if (x % 2 == 0) idx += 2
        if (y % 2 == 0) idx += 1
        isPossible[idx] = true
    }

    println(if (isPossible.contains(false)) "NO" else "YES")
}