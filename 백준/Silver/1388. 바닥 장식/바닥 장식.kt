import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    val isVisit = Array(N) { BooleanArray(M) }
    var cnt = 0
    val d = arrayOf(-1, 1)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (isVisit[i][j]) continue

            cnt++

            val q = LinkedList<Pos>()
            q.offer(Pos(j, i))
            isVisit[i][j]

            while (q.isNotEmpty()) {
                val c = q.poll()!!

                for (k in 0..1) {
                    if (map[c.y][c.x] == '-') {
                        val nx = c.x + d[k]

                        if (nx < 0 || nx >= M) continue
                        if (isVisit[c.y][nx]) continue
                        if (map[c.y][nx] == '|') continue

                        q.offer(Pos(nx, c.y))
                        isVisit[c.y][nx] = true
                    } else {
                        val ny = c.y + d[k]

                        if (ny < 0 || ny >= N) continue
                        if (isVisit[ny][c.x]) continue
                        if (map[ny][c.x] == '-') continue

                        q.offer(Pos(c.x, ny))
                        isVisit[ny][c.x] = true
                    }
                }
            }
        }
    }

    println(cnt)
}