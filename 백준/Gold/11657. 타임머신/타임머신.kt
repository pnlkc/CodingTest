fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val graph = Array(n + 1) { mutableMapOf<Int, Int>() }

    repeat(m) {
        val (a, b, c) = readln().split(' ').map(String::toInt)
        if (graph[a][b] == null) graph[a][b] = c else graph[a][b] = minOf(c, graph[a][b]!!)
    }

    val (result, arr) = calc(n, m, graph)

    if (result) arr.forEachIndexed { idx, i -> if (idx > 1) println(if (i != Long.MAX_VALUE) i else -1) }
    else println(-1)
}

fun calc(n: Int, m: Int, graph: Array<MutableMap<Int, Int>>): Pair<Boolean, LongArray> {
    val dist = LongArray(n + 1) { Long.MAX_VALUE }
    dist[1] = 0

    repeat(n - 1) {
        for (i in 1..n) {
            for ((cn, cd) in graph[i]) {
                if (dist[i] != Long.MAX_VALUE && dist[i] + cd < dist[cn]) {
                    dist[cn] = dist[i] + cd
                }
            }
        }
    }

    for (i in 1..n) {
        for ((cn, cd) in graph[i]) {
            if (dist[cn] != Long.MAX_VALUE && dist[i] + cd < dist[cn]) {
                return false to longArrayOf()
            }
        }
    }

    return true to dist
}