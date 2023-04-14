import java.util.*

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { mutableListOf<Int>() }
    val visit = IntArray(n)
    val queue = LinkedList<Int>()
    var visitCount = 1
    queue.add(r - 1)
    visit[r - 1] = visitCount++

    repeat(m) {
        readln().split(" ").map { it.toInt() - 1 }.run {
            graph[this[0]].add(this[1])
            graph[this[1]].add(this[0])
        }
    }

    graph.forEach { it.sort() }

    while (queue.isNotEmpty()) {
        val c = queue.poll()!!

        for (i in graph[c]) {
            if (visit[i] == 0) {
                visit[i] = visitCount++
                queue.add(i)
            }
        }
    }

    println(visit.joinToString("\n"))
}