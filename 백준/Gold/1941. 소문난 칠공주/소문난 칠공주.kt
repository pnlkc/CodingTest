import java.util.LinkedList

data class Pos(val x: Int, val y: Int)

val arr = Array(5) { CharArray(5) }
val pick = Array(7) { Pos(-1, -1) }
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var result = 0

fun main() {
    for (i in 0 until 5) {
        val input = readln()

        for (j in 0 until 5) {
            arr[i][j] = input[j]
        }
    }

    pick(0, 0, 0)

    println(result)
}

fun pick(cnt: Int, idx: Int, sCnt: Int) {
    if (cnt == 7) {
        if (bfs() && sCnt >= 4) result++
        return
    }

    if (idx > 24) return

    pick(cnt, idx + 1, sCnt)
    pick[cnt] = Pos(idx % 5, idx / 5)
    pick(cnt + 1, idx + 1, sCnt + if (arr[idx / 5][idx % 5] == 'S') 1 else 0)
}

fun bfs(): Boolean {
    val q = LinkedList<Pos>()
    val isVisit = BooleanArray(7)
    q.add(pick[0])
    isVisit[0] = true

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        for (d in 0..3) {
            val nx = c.x + dx[d]
            val ny = c.y + dy[d]

            if (nx < 0 || ny < 0 || nx > 4 || ny > 4) continue
            val idx = pick.indexOf(Pos(nx, ny))
            if (idx == -1 || isVisit[idx]) continue

            isVisit[idx] = true
            q.add(pick[idx])
        }
    }

    return !isVisit.contains(false)
}