fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toCharArray() }
    val wSum = Array(n + 1) { IntArray(m + 1) }
    val bSum = Array(n + 1) { IntArray(m + 1) }
    var answer = Int.MAX_VALUE

    for (i in 0 until n) {
        val r = intArrayOf(0, 0)
        for (j in 0 until m) {
            when {
                i % 2 == 0 && j % 2 == 0 -> if (arr[i][j] == 'B') incW(wSum, bSum, i, j, r) else incB(wSum, bSum, i, j, r)
                i % 2 == 0 -> if (arr[i][j] == 'B') incB(wSum, bSum, i, j, r) else incW(wSum, bSum, i, j, r)
                j % 2 == 0 -> if (arr[i][j] == 'B') incB(wSum, bSum, i, j, r) else incW(wSum, bSum, i, j, r)
                else -> if (arr[i][j] == 'B') incW(wSum, bSum, i, j, r) else incB(wSum, bSum, i, j, r)
            }
        }
    }

    for (i in k..n) {
        for (j in k..m) {
            answer = minOf(
                answer,
                wSum[i][j] - wSum[i - k][j] - wSum[i][j - k] + wSum[i - k][j - k],
                bSum[i][j] - bSum[i - k][j] - bSum[i][j - k] + bSum[i - k][j - k]
            )
        }
    }

    println(answer)
}

fun incW(wSum: Array<IntArray>, bSum: Array<IntArray>, i: Int, j: Int, row: IntArray) {
    wSum[i + 1][j + 1] = wSum[i][j + 1] + row[0] + 1
    bSum[i + 1][j + 1] = bSum[i][j + 1] + row[1]
    row[0]++
}

fun incB(wSum: Array<IntArray>, bSum: Array<IntArray>, i: Int, j: Int, row: IntArray) {
    wSum[i + 1][j + 1] = wSum[i][j + 1] + row[0]
    bSum[i + 1][j + 1] = bSum[i][j + 1] + row[1] + 1
    row[1]++
}