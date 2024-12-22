var g = arrayOf<MutableList<Int>>()
var isVisit = booleanArrayOf()
var dp = arrayOf<IntArray>()

fun main() {
    val N = readln().toInt()
    
    g = Array(N + 1) { mutableListOf() }
    isVisit = BooleanArray(N + 1)
    dp = Array (N + 1) { IntArray(2) { it } }

    for (i in 1 until N) {
        val (u, v) = readln().split(" ").map { it.toInt() }

        g[u].add(v)
        g[v].add(u)
    }

    dfs(1)
    println(minOf(dp[1][0], dp[1][1]))
}

fun dfs(n: Int) {
    isVisit[n] = true

    for (c in g[n]) {
        if (!isVisit[c]) {
            dfs(c)
            dp[n][0] += dp[c][1]
            dp[n][1] += dp[c].minOrNull()!!
        }
    }
}