import java.util.LinkedList

data class Pos(val x: Int, val t: Int)

fun main() {
    val (N, a, b) = readln().split(" ").map { it.toInt() }
    val isVisit = BooleanArray(N  + 1)
    val q = LinkedList<Pos>()

    q.add(Pos(0, 0))
    isVisit[0] = true

    while (q.isNotEmpty()) {
        val (cx, ct) = q.poll()!!

        if (cx == N) {
            println(ct)
            return
        }

        if (cx + 1 <= N && !isVisit[cx + 1]) {
            q.add(Pos(cx + 1, ct + 1))
            isVisit[cx + 1] = true
        }

        if (cx + a + 1 <= N && !isVisit[cx + a + 1]) {
            q.add(Pos(cx + a + 1, ct + 1))
            isVisit[cx + a + 1] = true
        }

        if (cx + b + 1 <= N && !isVisit[cx + b + 1]) {
            q.add(Pos(cx + b + 1, ct + 1))
            isVisit[cx + b + 1] = true
        }
    }
}