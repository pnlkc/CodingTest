import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val (R, C) = readln().split(" ").map { it.toInt() }
    val map = Array(R) { CharArray(C) }
    val q = LinkedList<Pos>()
    val isVisit = Array(R) { BooleanArray(C) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0 until R) {
        val input = readln()

        for (j in 0 until C) {
            map[i][j] = input[j]

            if (q.isEmpty() && map[i][j] == '.') {
                q.add(Pos(j, i))
                isVisit[i][j] = true
            }
        }
    }

    while (q.isNotEmpty()) {
        val c = q.poll()!!
        var cnt = 0

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue
            if (map[ny][nx] == 'X') continue

            cnt++

            if (isVisit[ny][nx]) continue

            q.add(Pos(nx, ny))
            isVisit[ny][nx] = true
        }

        if (cnt < 2) {
            println(1)
            return
        }
    }

    println(0)
}