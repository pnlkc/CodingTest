import java.util.LinkedList

fun main() {
    val (A, K) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(K + 1) { Int.MAX_VALUE }

    dp[A] = 0

    val q = LinkedList<Int>()

    q.add(A)

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        if (c + 1 <= K) {
            if (dp[c + 1] > dp[c] + 1) {
                dp[c + 1] = dp[c] + 1
                q.add(c + 1)
            }

        }

        if (c * 2 <= K) {
            if (dp[c * 2] > dp[c] + 1) {
                dp[c * 2] = dp[c] + 1
                q.add(c * 2)
            }
        }
    }

    println(dp[K])
}