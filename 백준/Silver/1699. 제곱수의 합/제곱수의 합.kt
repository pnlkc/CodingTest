import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val N = readln().toInt()
    val dp = IntArray(100_001) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 0..100_000) {
        for (j in 1..sqrt(100_000.toDouble()).toInt()) {
            if (i + j.toDouble().pow(2.0).toInt() > 100_000) break

            dp[i + j.toDouble().pow(2.0).toInt()] = minOf(dp[i + j.toDouble().pow(2.0).toInt()], dp[i] + 1)
        }
    }

    println(dp[N])
}