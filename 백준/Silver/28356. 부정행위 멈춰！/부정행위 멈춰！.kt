fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    var result = 1
    val dx = intArrayOf(1, 1, 1, -1, -1, -1, 0, 0)
    val dy = intArrayOf(1, 0, -1, 1, 0, -1, 1, -1)

    for (i in 0 until n) {
        for (j in 0 until m) {
            val temp = BooleanArray(10)

            for (d in 0.. 7) {
                val nx = j + dx[d]
                val ny = i + dy[d]

                if (nx < 0 || ny < 0 || ny >= n || nx >= m) continue

                temp[arr[ny][nx]] = true
            }

            for (k in 1..9) {
                if (!temp[k]) {
                    arr[i][j] = k
                    result = maxOf(result, k)
                    break
                }
            }
        }
    }

    sb.appendLine(result)
    arr.forEach { sb.appendLine(it.joinToString(" ")) }
    print(sb)
}