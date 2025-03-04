var graph = arrayOf<MutableList<Int>>()
var isVisit = intArrayOf()
var depthArr = intArrayOf()
var num = 1

fun main() {
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    var sum = 0L

    graph = Array(N + 1) { mutableListOf() }
    isVisit = IntArray(N + 1)
    depthArr = IntArray(N + 1) { -1 }

    for (i in 1..M) {
        val (u, v) = readln().split(" ").map { it.toInt() }

        graph[u].add(v)
        graph[v].add(u)
    }

    for (i in 1..N) {
        graph[i].sortDescending()
    }

    dfs(R, 0)

    for (i in 1..N) {
        sum += isVisit[i].toLong() * depthArr[i]
    }

    println(sum)
}

fun dfs(n: Int, depth: Int) {
    isVisit[n] = num++
    depthArr[n] = depth

    for (next in graph[n]) {
        if (isVisit[next] == 0) dfs(next, depth + 1)
    }
}