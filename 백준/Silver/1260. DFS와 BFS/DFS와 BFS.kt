import java.util.*

fun main() {
    val (n, m, v) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val dfsVisit = BooleanArray(n + 1) { false }
    val bfsVisit = BooleanArray(n + 1) { false }
    val dfsList = mutableListOf<Int>()
    val bfsList = mutableListOf<Int>()
    val queue = LinkedList<Int>()

    repeat(m) {
        readln().split(" ").run {
            graph[this[0].toInt()].add(this[1].toInt())
            graph[this[1].toInt()].add(this[0].toInt())
        }
    }

    graph.forEach { it.sort() }

    queue.add(v)
    bfsVisit[v] = true
    bfsList.add(v)

    while (queue.isNotEmpty()) {
        val c = queue.poll()!!

        for (i in graph[c]) {
            if (!bfsVisit[i]) {
                bfsVisit[i] = true
                bfsList.add(i)
                queue.add(i)
            }
        }
    }

    dfs(graph, dfsVisit, dfsList, v)

    println(dfsList.joinToString(" "))
    println(bfsList.joinToString(" "))
}

fun dfs(graph: Array<MutableList<Int>>, visit: BooleanArray, dfsList: MutableList<Int>, c: Int) {
    visit[c] = true
    dfsList.add(c)

    for (i in graph[c]) {
        if (!visit[i]) dfs(graph, visit, dfsList, i)
    }
}