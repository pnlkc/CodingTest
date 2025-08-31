import java.util.LinkedList
import kotlin.collections.isNotEmpty

data class Pos(val x: Int, val y: Int)

fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    val isVisit = Array(N) { IntArray(M) { -1 } }
    val result = Array(N) { CharArray(M) }
    var s = Pos(-1, -1)
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val dirMap = mutableMapOf(0 to 1, 1 to 0, 2 to 3, 3 to 2)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]
            result[i][j] = if (map[i][j] == '.') '@' else map[i][j]
        }
    }

    for (i in 0 until N) {
        if (map[i][0] == '.') {
            s = Pos(0, i)
            break
        }

        if (map[i][M - 1] == '.') {
            s = Pos(M - 1, i)
            break
        }
    }

    if (s.x == -1) {
        for (i in 0 until M) {
            if (map[0][i] == '.') {
                s = Pos(i, 0)
                break
            }

            if (map[N - 1][i] == '.') {
                s = Pos(i, N - 1)
                break
            }
        }
    }

    val q = LinkedList<Pos>()

    isVisit[s.y][s.x] = 4
    q.add(s)
    result[s.y][s.x] = '.'

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        if (c.x != s.x || c.y != s.y) {
            if (c.x == 0 || c.x == M - 1 || c.y == 0 || c.y == N - 1) {
                var nx = c.x
                var ny = c.y

                result[ny][nx] = '.'

                while (isVisit[ny][nx] in 0..3) {
                    val dir = dirMap[isVisit[ny][nx]]!!

                    nx += dx[dir]
                    ny += dy[dir]
                    result[ny][nx] = '.'
                }

                break
            }
        }

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
            if (isVisit[ny][nx] != -1) continue
            if (map[ny][nx] != '.') continue

            isVisit[ny][nx] = d
            q.add(Pos(nx, ny))
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            sb.append(result[i][j])
        }

        sb.appendLine()
    }

    print(sb)
}