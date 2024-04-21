import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    for (i in 1..m) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        graph[a].add(b)
        graph[b].add(a)
    }

    val q = readln().toInt()

    for (tc in 1..q) {
        val (a, i, j) = readln().split(" ").map { it.toInt() }

        if (a == 1) {
            graph[i].add(j)
            graph[j].add(i)
        } else {
            graph[i].remove(j)
            graph[j].remove(i)
        }

        val queue = LinkedList<Int>()
        val isVisit = IntArray(n + 1)

        queue.add(1)

        while (queue.isNotEmpty()) {
            val c = queue.poll()!!

            for (next in graph[c]) {
                if (next == 1) continue
                if (isVisit[next] != 0) continue

                queue.add(next)
                isVisit[next] = isVisit[c] + 1
            }
        }

        sb.appendLine(
            isVisit
                .drop(1)
                .mapIndexed { idx, num -> if (idx != 0 && num == 0) -1 else num }
                .joinToString(" ")
        )
    }

    print(sb)
}