fun main() {
    val sb = StringBuilder()
    val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
    val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1)

    while (true) {
        val (R, C) = readln().split(" ").map { it.toInt() }
        if (R == 0 && C == 0) break
        val map = Array(R) { CharArray(C) }
        val result = Array(R) { Array(C) { "" } }

        for (i in 0 until R) {
            val input = readln()

            for (j in 0 until C) {
                map[i][j] = input[j]
            }
        }

        for (i in 0 until R) {
            for (j in 0 until C) {
                if (map[i][j] == '*') {
                    result[i][j] = "*"
                    continue
                }

                var cnt = 0

                for (d in 0 until 8) {
                    val nx = j + dx[d]
                    val ny = i + dy[d]

                    if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue

                    if (map[ny][nx] == '*') cnt++
                }

                result[i][j] = cnt.toString()
            }
        }

        for (i in 0 until R) {
            sb.appendLine(result[i].joinToString(""))
        }
    }

    print(sb)
}