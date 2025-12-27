import java.util.LinkedList
import kotlin.math.abs

data class Pos(val x: Int, val y: Int)

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val map = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until m) {
            map[i][j] = input[j]
        }
    }

    val x = readln().toInt()
    val start = map[0][0]
    val q = LinkedList<Pos>()
    val isVisit = Array(n) { BooleanArray(m) }

    isVisit[0][0] = true
    q.add(Pos(0, 0))

    while (q.isNotEmpty()) {
        val (cx, cy) = q.poll()!!

        if (cx == m - 1 && cy == n - 1) {
            println("ALIVE")
            return
        }

        for (i in -x..x) {
            for (j in -x..x) {
                if (abs(i) + abs(j) > x) continue

                val nx = cx + i
                val ny = cy + j

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue
                if (isVisit[ny][nx]) continue
                if (map[ny][nx] != start) continue

                isVisit[ny][nx] = true
                q.add(Pos(nx, ny))
            }
        }
    }

    println("DEAD")
}