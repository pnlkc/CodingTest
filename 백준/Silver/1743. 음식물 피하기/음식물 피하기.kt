import java.util.LinkedList

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { BooleanArray(M) }
    val isVisit = Array(N) { BooleanArray(M) }
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    var result = 0

    for (i in 1..K) {
        val (r, c) = readln().split(" ").map { it.toInt() - 1 }

        map[r][c] = true
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (isVisit[i][j] || !map[i][j]) continue

            var cnt = 0
            val q = LinkedList<Pair<Int, Int>>()

            q.add(j to i)
            isVisit[i][j] = true

            while (q.isNotEmpty()) {
                val (cx, cy) = q.poll()!!

                cnt++

                for (d in 0..3) {
                    val nx = cx + dx[d]
                    val ny = cy + dy[d]

                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue
                    if (isVisit[ny][nx]) continue
                    if (!map[ny][nx]) continue

                    q.add(nx to ny)
                    isVisit[ny][nx] = true
                }
            }

            result = maxOf(result, cnt)
        }
    }

    println(result)
}