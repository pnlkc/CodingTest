import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { CharArray(N) }
    val isVisit = Array(M) { BooleanArray(N) }
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val result = intArrayOf(0, 0)

    for (i in 0 until M) {
        val input = readln()

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    val q = LinkedList<Pos>()

    for (i in 0 until M) {
        for (j in 0 until N) {
            if (isVisit[i][j]) continue

            var cnt = 1
            val current = map[i][j]
            q.add(Pos(j, i))
            isVisit[i][j] = true

            while (q.isNotEmpty()) {
                val c = q.poll()!!

                for (d in 0 until 4) {
                    val nx = c.x + dx[d]
                    val ny = c.y + dy[d]

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
                    if (isVisit[ny][nx]) continue
                    if (map[ny][nx] != current) continue

                    cnt++
                    q.add(Pos(nx, ny))
                    isVisit[ny][nx] = true
                }
            }

            result[if (current == 'W') 0 else 1] += cnt * cnt
        }
    }

    println("${result[0]} ${result[1]}")
}