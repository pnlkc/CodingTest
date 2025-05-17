import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val before = Array(N) { IntArray(M) }
    val after = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            before[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until M) {
            after[i][j] = input[j]
        }
    }

    var ori = 0
    var target = 0
    val q = LinkedList<Pos>()
    val isVisit = Array(N) { BooleanArray(M) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    p@ for (i in 0 until N) {
        for (j in 0 until M) {
            if (before[i][j] != after[i][j]) {
                ori = before[i][j]
                target = after[i][j]
                q.add(Pos(j, i))
                isVisit[i][j] = true
                before[i][j] = target
                break@p
            }
        }
    }

    while (ori != 0 && q.isNotEmpty()) {
        val c = q.poll()!!

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
            if (isVisit[ny][nx]) continue
            if (before[ny][nx] != ori) continue

            isVisit[ny][nx] = true
            before[ny][nx] = target
            q.add(Pos(nx, ny))
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (before[i][j] != after[i][j]) {
                println("NO")
                return
            }
        }
    }

    println("YES")
}