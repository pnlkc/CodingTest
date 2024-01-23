import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val q = LinkedList<Pair<Int, Int>>()
    val isVisit = BooleanArray(n + 1)

    for (i in 1..m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }

    q.add(a to 0)
    isVisit[a] = true

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        if(c.first == b) {
            println(c.second)
            return
        }

        graph[c.first].forEach { next ->
            if (!isVisit[next]) {
                q.add(next to c.second + 1)
                isVisit[next] = true
            }
        }
    }

    println(-1)
}