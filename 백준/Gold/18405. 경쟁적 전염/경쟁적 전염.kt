import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

data class Pos(val n: Int, val x: Int, val y: Int, val t: Int)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }
    val q: Queue<Pos> = LinkedList()

    for (i in 0 until n) {
        val st = StringTokenizer(readln())

        for (j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    val (s, x, y) = readln().split(" ").map { it.toInt() }

    for (num in 1..k) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j] == num) q.offer(Pos(num, j, i, 0))
            }
        }
    }

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        if (c.t > s) break

        if (c.x == y - 1 && c.y == x - 1) {
            println(c.n)
            return
        }

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx !in 0 until n || ny !in 0 until n) continue

            if (map[ny][nx] != 0) continue

            map[ny][nx] = c.n
            q.offer(Pos(c.n, nx, ny, c.t + 1))
        }
    }

    println(0)
}