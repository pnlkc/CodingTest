import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val graph = Array(101) { (it + 1..it + 6).toMutableList() }
    val isSpecial = BooleanArray(101)
    val queue = LinkedList<Pair<Int, Int>>()
    val visit = IntArray(101) { -1 }

    repeat(n + m) {
        val (x, y) = readln().split(" ").map(String::toInt)
        graph[x] = mutableListOf(y)
        isSpecial[x] = true
    }

    queue.add(1 to 0)
    visit[1] = 0

    while (queue.isNotEmpty()) {
        val (c, d) = queue.poll()!!

        for (i in graph[c]) {
            if (i > 100) continue

            if (visit[i] == -1 || visit[i] > d + 1) {
                if (isSpecial[i]) {
                    if (visit[graph[i].first()] == -1 || visit[graph[i].first()] > d + 1) {
                        visit[graph[i].first()] = d + 1
                        queue.add(graph[i].first() to d + 1)
                    }
                } else {
                    queue.add(i to d + 1)
                    visit[i] = d + 1
                }
            }

            if (i == 100) break
        }
    }

    println(visit[100])
}