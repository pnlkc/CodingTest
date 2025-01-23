import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()
    var map: Array<CharArray>
    var isVisit: Array<BooleanArray>
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (tc in 1..T) {
        val (H, W) = readln().split(" ").map { it.toInt() }
        var cnt = 0
        val q = LinkedList<Pos>()

        map = Array(H) { CharArray(W) }
        isVisit = Array(H) { BooleanArray(W) }

        for (i in 0 until H) {
            val input = readln()

            for (j in 0 until W) {
                map[i][j] = input[j]
            }
        }

        for (i in 0 until H) {
            for (j in 0 until W) {
                if (isVisit[i][j] || map[i][j] == '.') continue

                cnt++
                isVisit[i][j] = true
                q.offer(Pos(j, i))

                while (q.isNotEmpty()) {
                    val c = q.poll()!!

                    for (d in 0..3) {
                        val nx = c.x + dx[d]
                        val ny = c.y + dy[d]

                        if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue
                        if (isVisit[ny][nx] || map[ny][nx] == '.') continue

                        isVisit[ny][nx] = true
                        q.offer(Pos(nx, ny))
                    }
                }
            }
        }

        sb.appendLine(cnt)
    }

    print(sb)
}