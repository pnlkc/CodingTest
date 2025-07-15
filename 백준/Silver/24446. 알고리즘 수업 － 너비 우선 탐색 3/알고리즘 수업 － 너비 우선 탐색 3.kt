import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    val graph = Array(N) { mutableListOf<Int>() }
    val q = LinkedList<Int>()
    val isVisit = IntArray(N) { -1 }

    repeat (M) {
        val (u, v) = readln().split(" ").map { it.toInt() - 1 }

        graph[u].add(v)
        graph[v].add(u)
    }

    q.add(R - 1)
    isVisit[R - 1] = 0

    while (q.isNotEmpty()) {
        val c = q.poll()!!
        val d = isVisit[c]

        for (n in graph[c]) {
            if (isVisit[n] != -1) continue

            q.add(n)
            isVisit[n] = d + 1
        }
    }

    for (i in 0 until N) {
        sb.appendLine(isVisit[i])
    }

    print(sb)
}