import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val (R, C) = readln().split(" ").map { it.toInt() }
    val map = Array(R) { CharArray(C) }
    var s = 0
    var w = 0

    for (i in 0 until R) {
        val input = readln()

        for (j in 0 until C) {
            map[i][j] = input[j]
        }
    }

    val isVisit = Array(R) { BooleanArray(C) }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (isVisit[i][j]) continue
            if (map[i][j] == '#') continue

            var cs = 0
            var cw = 0
            if (map[i][j] == 'o') cs++
            if (map[i][j] == 'v') cw++
            val q = LinkedList<Pos>()
            isVisit[i][j] = true
            q.offer(Pos(j, i))

            while (q.isNotEmpty()) {
                val (cx, cy) = q.poll()!!

                for (d in 0..3) {
                    val nx = cx + dx[d]
                    val ny = cy + dy[d]

                    if (nx < 0 || ny < 0 || nx >= C || ny >=R) continue
                    if (isVisit[ny][nx] || map[ny][nx] == '#') continue

                    q.offer(Pos(nx, ny))
                    isVisit[ny][nx] = true

                    if (map[ny][nx] == 'o') cs++
                    if (map[ny][nx] == 'v') cw++
                }
            }

            if (cs > cw) s += cs else w += cw
        }
    }

    println("$s $w")
}