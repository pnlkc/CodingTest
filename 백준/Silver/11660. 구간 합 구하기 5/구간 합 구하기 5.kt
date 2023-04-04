fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val s = StringBuilder()

    for (i in arr.indices) {
        for (j in 1 until n) {
            arr[i][j] += arr[i][j - 1]
        }
    }

    for (i in arr.indices) {
        for (j in 1 until n) {
            arr[j][i] += arr[j - 1][i]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() - 1 }
        var num = arr[x2][y2]
        if (x1 in 1..n) num -= arr[x1 - 1][y2]
        if (y1 in 1..n) num -= arr[x2][y1 - 1]
        if (x1 in 1..n && y1 in 1..n) num += arr[x1 - 1][y1 - 1]
        s.appendLine(num)
    }

    println(s.toString())
}
