import java.util.PriorityQueue

data class Pos(val x: Int, val y: Int, val dir: Int, val cnt: Int)

fun main() {
    val (M, N) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { IntArray(N) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val dirMap = mutableMapOf(
        0 to intArrayOf(2, 3),
        1 to intArrayOf(2, 3),
        2 to intArrayOf(0, 1),
        3 to intArrayOf(0, 1),
    )

    for (i in 0 until M) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    val s = readln().split(" ").map { it.toInt() - 1 }.let { Pos(it[1], it[0], it[2], 0) }
    val e = readln().split(" ").map { it.toInt() - 1 }.let { Pos(it[1], it[0], it[2], 0) }

    val q = PriorityQueue<Pos>(compareBy { it.cnt })
    val isVisit = Array(M) { Array(N) { IntArray(4) { Int.MAX_VALUE } } }

    q.add(s)
    isVisit[s.y][s.x][s.dir] = 0

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        if (isVisit[c.y][c.x][c.dir] < c.cnt) {
            continue
        }

        for (d in 1..3) {
            val nx = c.x + dx[c.dir] * d
            val ny = c.y + dy[c.dir] * d

            if (nx in 0 until N && ny in 0 until M) {
                if (map[ny][nx] == 1) break
                if (isVisit[ny][nx][c.dir] > c.cnt + 1) {
                    q.add(Pos(nx, ny, c.dir, c.cnt + 1))
                    isVisit[ny][nx][c.dir] = c.cnt + 1
                }
            }
        }


        if (isVisit[c.y][c.x][dirMap[c.dir]!![0]] > c.cnt + 1) {
            q.add(Pos(c.x, c.y, dirMap[c.dir]!![0], c.cnt + 1))
            isVisit[c.y][c.x][dirMap[c.dir]!![0]] = c.cnt + 1
        }

        if (isVisit[c.y][c.x][dirMap[c.dir]!![1]] > c.cnt + 1) {
            q.add(Pos(c.x, c.y, dirMap[c.dir]!![1], c.cnt + 1))
            isVisit[c.y][c.x][dirMap[c.dir]!![1]] = c.cnt + 1
        }
    }

    println(isVisit[e.y][e.x][e.dir])
}