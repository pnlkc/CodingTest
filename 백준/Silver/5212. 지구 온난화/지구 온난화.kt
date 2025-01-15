fun main() {
    val sb = StringBuilder()
    val (R, C) = readln().split(" ").map { it.toInt() }
    val map = Array(R) { CharArray(C) }
    val result = Array(R) { CharArray(C) { '.' } }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0 until R) {
        val input = readln()

        for (j in 0 until C) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (map[i][j] == '.') continue

            var cnt = 0

            for (d in 0..3) {
                val nx = j + dx[d]
                val ny = i + dy[d]

                if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                    cnt++
                    continue
                }
                if (map[ny][nx] == '.') cnt++
            }

            if (cnt < 3) result[i][j] = 'X'
        }
    }

    var minX = C - 1
    var maxX = 0
    var minY = R - 1
    var maxY = 0

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (result[i][j] == 'X') {
                minX = minOf(minX, j)
                maxX = maxOf(maxX, j)
                minY = minOf(minY, i)
                maxY = maxOf(maxY, i)
            }
        }
    }

    for (i in minY..maxY) {
        for (j in minX..maxX) {
            sb.append(result[i][j])
        }

        sb.appendLine()
    }

    print(sb)
}