import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    var cnt = 0

    for (i in 1..m) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        graph[a].add(b)
        graph[b].add(a)
    }

    val q = LinkedList<Int>()
    val isVisit = IntArray(n + 1)

    q.add(1)
    isVisit[1] = 0

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        for (next in graph[c]) {
            if (next == 1) continue

            if (isVisit[next] == 0 && isVisit[c] < 2) {
                q.add(next)
                isVisit[next] = isVisit[c] + 1
                cnt++
            }
        }
    }

    println(cnt)
}