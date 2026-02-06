fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    var result = 1

    for (i in 0 until n) {
        val num = if (i % 2 == 0) 1 else if (m == 1) 2 else 3

        for (j in 0 until m) {
            arr[i][j] = num + j % 2
            result = maxOf(result, arr[i][j])
        }
    }

    sb.appendLine(result)
    arr.forEach { sb.appendLine(it.joinToString(" ")) }
    print(sb)
}