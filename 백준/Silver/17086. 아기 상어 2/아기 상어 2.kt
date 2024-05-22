import java.util.LinkedList

data class Pos(val x: Int, val y: Int, val n: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    val dx = intArrayOf(1, 1, 1, -1, -1, -1, 0, 0)
    val dy = intArrayOf(1, 0, -1, 1, 0, -1, 1, -1)
    var max = 0

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        p@ for (j in 0 until M) {
            if (map[i][j] == 1) continue

            val q = LinkedList<Pos>()
            val isVisit = Array(N) { BooleanArray(M) }

            q.add(Pos(j, i, 0))
            isVisit[i][j] = true

            while (q.isNotEmpty()) {
                val c = q.poll()!!

                for (d in 0 until 8) {
                    val nx = c.x + dx[d]
                    val ny = c.y + dy[d]

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
                    if (isVisit[ny][nx]) continue

                    isVisit[ny][nx] = true

                    if (map[ny][nx] == 1) {
                        max = maxOf(max, c.n + 1)
                        continue@p
                    }
                    
                    q.offer(Pos(nx, ny, c.n + 1))
                }
            }
        }
    }

    println(max)
}