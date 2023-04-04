fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val s = StringBuilder()

    for (i in 0 until n) {
        for (j in 0 until n) {
            arr[i][j] = calc(arr, n , i, j, i, j, true)
        }
    }
    
    repeat(m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() - 1 }
        s.appendLine(calc(arr, n, x1, y1, x2, y2, false))
    }

    println(s.toString())
}

fun calc(arr: Array<IntArray>, n: Int, x1: Int, y1: Int, x2: Int, y2: Int, isAdd: Boolean): Int {
    var num = arr[x2][y2]
    if (x1 in 1..n) num += arr[x1 - 1][y2] * if (!isAdd) -1 else 1
    if (y1 in 1..n) num += arr[x2][y1 - 1] * if (!isAdd) -1 else 1
    if (x1 in 1..n && y1 in 1..n) num -= arr[x1 - 1][y1 - 1] * if (!isAdd) -1 else 1
    return num
}