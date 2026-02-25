fun main() {
    val n = readln().toInt()
    val num = n * (n * n + 1) / 2
    val arr = Array(n) { IntArray(n) }
    var result = true
    val cnt = IntArray(n * n + 1)

    for (i in 0 until n) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until n) {
            arr[i][j] = input[j]
            if (++cnt[arr[i][j]] > 1) result = false
        }
    }

    for (i in 0 until n) {
        var sumA = 0
        var sumB = 0

        for (j in 0 until n) {
            sumA += arr[i][j]
            sumB += arr[j][i]
        }

        if (sumA != num || sumB != num) {
            result = false
            break
        }
    }

    var sumA = 0
    var sumB = 0

    for (i in 0 until n) {
        sumA += arr[i][i]
        sumB += arr[i][n - i - 1]
    }

    if (sumA != num || sumB != num) result = false

    println(if (result) "TRUE" else "FALSE")
}
