import java.util.LinkedList

data class Pos(val x: Int, val w: Int)

fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (W, N) = readln().split(" ").map { it.toInt() }
        var q = LinkedList<Pos>()
        var dist = 0

        for (i in 1..N) {
            val (x, w) = readln().split(" ").map { it.toInt() }

            q.offer(Pos(x, w))
        }

        var carWeight = 0
        var temp = LinkedList<Pos>()

        while (q.isNotEmpty()) {
            val (cx, cw) = q.poll()!!

            if (carWeight + cw >= W) {
                dist += cx * 2
                if (carWeight + cw > W) temp.add(Pos(cx, cw))
                temp.addAll(q)
                q = temp
                temp = LinkedList<Pos>()
                carWeight = 0
                continue
            }

            if (q.isEmpty()) {
                dist += cx * 2
                break
            }

            carWeight += cw
        }

        sb.appendLine(dist)
    }

    print(sb)
}