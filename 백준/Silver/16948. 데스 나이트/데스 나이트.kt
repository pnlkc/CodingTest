import java.util.LinkedList

data class Pos(val x: Int, val y: Int, val n: Int)

fun main() {
    val dy = intArrayOf(-2, -2, 0, 0, 2, 2)
    val dx = intArrayOf(-1, 1, -2, 2, -1, 1)
    val N = readln().toInt()
    val (r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }
    val isVisit = Array(N) { BooleanArray(N) }
    val q = LinkedList<Pos>()

    q.offer(Pos(c1, r1, 0))
    isVisit[r1][c1] = true

    while (q.isNotEmpty()) {
        val (cx, cy, cn) = q.poll()!!

        if (cx == c2 && cy == r2) {
            println(cn)
            return
        }

        for (d in 0..5) {
            val nx = cx + dx[d]
            val ny = cy + dy[d]

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue
            if (isVisit[ny][nx]) continue

            q.offer(Pos(nx, ny, cn + 1))
            isVisit[ny][nx] = true
        }
    }

    println(-1)
}