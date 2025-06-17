fun main() {
    val N = readln().toInt()
    val tree = Array(N + 1) { mutableListOf<Int>() }
    val cnt = IntArray(N + 1) { 1 }
    val isVisit = BooleanArray(N + 1)
    var result = 0L
    val allNum = N.toLong() * (N - 1) / 2

    for (i in 1 until N) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        tree[a].add(b)
        tree[b].add(a)
    }

    calcCnt(1, tree, isVisit, cnt)

    for (i in 2..N) {
           result += allNum - (N - cnt[i]).toLong() * (N - cnt[i] - 1) / 2
    }

    println(result)
}

fun calcCnt(node: Int, tree: Array<MutableList<Int>>, isVisit: BooleanArray, cnt: IntArray): Int {
    isVisit[node] = true

    for (next in tree[node]) {
        if (!isVisit[next]) {
            cnt[next] = calcCnt(next, tree, isVisit, cnt)
            cnt[node] += cnt[next]
        }
    }

    return cnt[node]
}