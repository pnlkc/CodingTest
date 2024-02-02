import java.util.LinkedList

fun main() {
    val (F, S, G, U, D) = readln().split(" ").map { it.toInt() }
    val q = LinkedList<Pair<Int, Int>>()
    val isVisit = IntArray(F + 1) { Int.MAX_VALUE }

    q.offer(S to 0)
    isVisit[S] = 0

    while (q.isNotEmpty()) {
        val (floor, cnt) = q.poll()!!

        if (floor == G) {
            println(cnt)
            return
        }

        val up = floor + U
        if (up <= F && isVisit[up] > cnt + 1) {
            q.add(up to cnt + 1)
            isVisit[up] = cnt + 1
        }

        val down = floor - D
        if (down >= 1 && isVisit[down] > cnt + 1) {
            q.add(down to cnt + 1)
            isVisit[down] = cnt + 1
        }
    }

    println("use the stairs")
}