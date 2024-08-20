import java.util.LinkedList
import java.util.StringTokenizer

data class Pos(val x: Int, val y: Int)

fun main() {
    val N = readln().toInt()
    val map = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        val st = StringTokenizer(readln())

        for (j in 0 until N) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    val q = LinkedList<Pos>()
    val isVisit = Array(N) { BooleanArray(N) }

    q.offer(Pos(0, 0))
    isVisit[0][0] = true

    while (q.isNotEmpty()) {
        val (cx, cy) = q.poll()!!
        val d = map[cy][cx]

        if (cx == N - 1 && cy == N - 1) {
            println("HaruHaru")
            return
        }

        if (cx + d < N && !isVisit[cy][cx + d]) {
            q.offer(Pos(cx + d, cy))
            isVisit[cy][cx + d] = true
        }

        if (cy + d < N && !isVisit[cy + d][cx]) {
            q.offer(Pos(cx, cy + d))
            isVisit[cy + d][cx] = true
        }
    }

    println("Hing")
}