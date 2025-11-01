import kotlin.math.abs

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val dp = Array(h + 1) { IntArray(w) { Int.MAX_VALUE } }
    val b1 = Array(h) { readln().split(" ").map { it.toInt() } }
    val b2 = Array(h) { readln().split(" ").map { it.toInt() } }

    dp[0].fill(0)

    for (i in 1..h) {
        for (j in 0 until w) {
            for (d in -1..1) {
                val nx = j + d

                if (nx !in 0 until w) continue

                val diff = abs(b1[i - 1][j] - b2[i - 1][j])

                dp[i][j] = minOf(dp[i][j], dp[i - 1][nx] + diff * diff)
            }
        }
    }

    println(dp[h].min())
}