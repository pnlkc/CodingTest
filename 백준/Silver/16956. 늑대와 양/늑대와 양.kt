import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val sb = StringBuilder()
    val (R, C) = readln().split(" ").map { it.toInt() }
    val map = Array(R) { CharArray(C) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val q = LinkedList<Pos>()
    val isVisit = Array(R) { BooleanArray(C) }

    for (i in 0 until R) {
        val input = readln()

        for (j in 0 until C) {
            map[i][j] = input[j]

            if (map[i][j] == '.') {
                map[i][j] = 'D'
                isVisit[i][j] = true
            }
        }
    }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (isVisit[i][j]) continue
            if (map[i][j] == 'W') {
                q.add(Pos(j, i))
                isVisit[i][j] = true

                while (q.isNotEmpty()) {
                   val c = q.poll()!!

                    for (d in 0..3) {
                        val nx = c.x + dx[d]
                        val ny = c.y + dy[d]

                        if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue
                        if (isVisit[ny][nx]) continue
                        
                        if (map[ny][nx] == 'S') {
                            println(0)
                            return
                        } else {
                            q.add(Pos(nx, ny))
                            isVisit[ny][nx] = true
                        }
                    }
                }
            }
        }
    }

    sb.appendLine(1)
    for (i in 0 until R) {
        sb.appendLine(map[i].joinToString(""))
    }
    print(sb)
}