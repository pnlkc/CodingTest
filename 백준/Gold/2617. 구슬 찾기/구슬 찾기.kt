var isVisit = booleanArrayOf()
var graphA = arrayOf<MutableList<Int>>()
var graphB = arrayOf<MutableList<Int>>()
var result = booleanArrayOf()
var childCnt = 0

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    graphA = Array(N + 1) { mutableListOf() }
    graphB = Array(N + 1) { mutableListOf() }
    result = BooleanArray(N + 1) { true }

    for (i in 1..M) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        graphA[m].add(n)
        graphB[n].add(m)
    }

    for (num in 1..N) {
        isVisit = BooleanArray(N + 1)
        childCnt = 0
        dfs(num, num, N, true)

        isVisit = BooleanArray(N + 1)
        childCnt = 0
        dfs(num, num, N, false)
    }

    println(result.count { !it })
}

fun dfs(start: Int, num: Int, N:Int, type: Boolean) {
    isVisit[num] = true
    childCnt++

    if (childCnt > (N + 1) / 2) {
        result[start] = false
    }

    for (next in if(type) graphA[num] else graphB[num]) {
        if (!isVisit[next]) dfs(start, next, N, type)
    }
}