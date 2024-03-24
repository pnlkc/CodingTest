import java.util.PriorityQueue

data class Data(val x: Int, val y: Int, val d: Int)

fun main() {
    val n = readln().toInt()
    val map = mutableListOf<List<Int>>()
    val dp = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val dx = intArrayOf(0, 1)
    val dy = intArrayOf(1, 0)

    for (i in 0 until n) {
        map.add(readln().split(" ").map { it.toInt() })
    }

    val pq = PriorityQueue<Data>(compareBy { it.d })
    pq.add(Data(0, 0, 0))
    dp[0][0] = 0

    while (pq.isNotEmpty()) {
        val c = pq.poll()!!

        if (c.d > dp[c.y][c.x]) continue

        for (d in 0..1) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx >= n || ny >= n) {
                continue
            }

            var add = 0

            if (map[c.y][c.x] <= map[ny][nx]) {
                add = map[ny][nx] - map[c.y][c.x] + 1
            }

            if (dp[ny][nx] > c.d + add) {
                pq.add(Data(nx, ny, c.d + add))
                dp[ny][nx] = c.d + add
            }
        }
    }
    
    println(dp[n - 1][n - 1])
}