var result = Int.MAX_VALUE

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { IntArray(N) }
    val isVisit = BooleanArray(N)

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            arr[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        isVisit[i] = true
        calc(i, i, 0, isVisit, arr)
        isVisit[i] = false
    }

    println(result)
}

fun calc(s: Int, c: Int, n: Int, isVisit: BooleanArray, arr: Array<IntArray>) {
    if (!isVisit.contains(false)) {
        if (arr[c][s] != 0) result = minOf(result, n + arr[c][s])
        return
    }

    if (result <= n) return

    for (i in isVisit.indices) {
        if (isVisit[i]) continue
        if (arr[c][i] == 0) continue

        isVisit[i] = true
        calc(s, i, n + arr[c][i], isVisit, arr)
        isVisit[i] = false
    }
}