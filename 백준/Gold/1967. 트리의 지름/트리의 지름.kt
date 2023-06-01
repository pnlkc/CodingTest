fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(n - 1) {
        val (a, b, c) = readln().split(' ').map(String::toInt)
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val visitA = IntArray(n + 1) { -1 }
    val maxA = intArrayOf(0, 0)
    dfs(graph, visitA, 1, 0, maxA)

    val visitB = IntArray(n + 1) { -1 }
    val maxB = intArrayOf(0, 0)
    dfs(graph, visitB, maxA[1], 0, maxB)

    println(maxB[0])
}

fun dfs(
    graph: Array<MutableList<Pair<Int, Int>>>,
    visit: IntArray,
    node: Int,
    depth: Int,
    max: IntArray
) {
    visit[node] = depth
    if (depth > max[0]) {
        max[0] = depth
        max[1] = node
    }

    for (i in graph[node]) {
        if (visit[i.first] == -1) dfs(graph, visit, i.first, depth + i.second, max)
    }
}