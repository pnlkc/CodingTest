import java.util.LinkedList

data class Pos(val x: Int, val y: Int, val n: Int)

fun main() {
    val (r1, c1) = readln().split(" ").map { it.toInt() }
    val (r2, c2) = readln().split(" ").map { it.toInt() }
    val dL = arrayOf(
        listOf(0 to -1, -1 to -1, -1 to -1),
        listOf(0 to -1, 1 to -1, 1 to -1),
        listOf(1 to 0, 1 to -1, 1 to -1),
        listOf(1 to 0, 1 to 1, 1 to 1),
        listOf(0 to 1, 1 to 1, 1 to 1),
        listOf(0 to 1, -1 to 1, -1 to 1),
        listOf(-1 to 0, -1 to -1, -1 to -1),
        listOf(-1 to 0, -1 to 1, -1 to 1),
    )
    val isVisit = Array(10) { BooleanArray(9) }
    val q = LinkedList<Pos>()

    q.add(Pos(c1, r1, 0))
    isVisit[r1][c1] = true

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        p@ for (d in 0 until 8) {
            var nx = c.x
            var ny = c.y
            var cnt = 0

            for ((dx, dy) in dL[d]) {
                cnt++
                nx += dx
                ny += dy

                if (nx < 0 || ny < 0 || nx > 8 || ny > 9) continue@p
                if (nx == c2 && ny == r2) {
                    if (cnt == 3) {
                        println(c.n + 1)
                        return
                    } else {
                        continue@p
                    }
                }
            }

            if (isVisit[ny][nx]) continue

            q.add(Pos(nx, ny, c.n + 1))
            isVisit[ny][nx] = true
        }
    }
}