import java.util.LinkedList
import java.util.StringTokenizer

data class Pos(val x: Int, val y: Int, val d: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    var result = 0 to 0

    for (i in 0 until N) {
        val st = StringTokenizer(readln())

        for (j in 0 until M) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 0) continue

            val q = LinkedList<Pos>()
            val isVisit = Array(N) { BooleanArray(M) }
            isVisit[i][j] = true
            q.add(Pos(j, i, 0))

            var maxPos = Pos(0, 0, 0)

            while (q.isNotEmpty()) {
                val c = q.poll()!!

                if (maxPos.d < c.d) maxPos = c
                if (maxPos.d == c.d && maxPos.x + maxPos.y < c.x + c.y) maxPos = c

                for (d in 0..3) {
                    val nx = c.x + dx[d]
                    val ny = c.y + dy[d]

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
                    if (isVisit[ny][nx]) continue
                    if (map[ny][nx] == 0) continue

                    isVisit[ny][nx] = true
                    q.add(Pos(nx, ny, c.d + 1))
                }
            }

            if (result.second < maxPos.d) {
                result = map[i][j] + map[maxPos.y][maxPos.x] to maxPos.d
            }
            if (maxPos.d == result.second) {
                val sum = map[i][j] + map[maxPos.y][maxPos.x]

                if (result.first < sum) {
                    result = sum to maxPos.d
                }
            }
        }
    }

    println(result.first)
}