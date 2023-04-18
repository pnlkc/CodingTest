import java.util.PriorityQueue

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val arr = Array(m) { readln().split(" ").map { it.toInt() } }
    val queue = PriorityQueue<Pair<Int, Int>>(compareByDescending { arr[it.second][it.first] })
    val dp = Array(m) { IntArray(n) }

    dp[0][0] = 1
    queue.add(0 to 0)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()!!

        if (y == arr.lastIndex && x == arr[0].lastIndex) continue

        val yR = intArrayOf(1, -1, 0, 0)
        val xR = intArrayOf(0, 0, 1, -1)

        for (i in 0..3) {
            val nx = x + xR[i]
            val ny = y + yR[i]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (arr[y][x] <= arr[ny][nx]) continue

            if (dp[ny][nx] == 0) {
                dp[ny][nx] = dp[y][x]
                queue.add(nx to ny)
            } else {
                dp[ny][nx] += dp[y][x]
            }
        }
    }

    println(dp[m - 1][n - 1])
}