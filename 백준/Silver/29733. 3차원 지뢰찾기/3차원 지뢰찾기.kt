fun main() {
    val sb = StringBuilder()
    val (R, C, H) = readln().split(" ").map { it.toInt() }
    val map = Array(R) { Array(C) { CharArray(H) } }
    val result = Array(R) { Array(C) { IntArray(H) } }
    val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1, 1, 1, 1, 0, 0, 0, -1, -1, -1, 1, 1, 1, 0, 0, 0, -1, -1, -1)
    val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1)
    val dz = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1)

    for (h in 0 until H) {
        for (r in 0 until R) {
            val input = readln()

            for (c in 0 until C) {
                map[r][c][h] = input[c]
            }
        }
    }

    for (h in 0 until H) {
        for (r in 0 until R) {
            for (c in 0 until C) {
                if (map[r][c][h] == '*') {
                    result[r][c][h] = -1
                } else {
                    var cnt = 0

                    for (d in 0 until 26) {
                        val nx = c + dx[d]
                        val ny = r + dy[d]
                        val nz = h + dz[d]

                        if (nx < 0 || ny < 0 || nz < 0 || nx >= C || ny >= R || nz >= H) continue
                        if (map[ny][nx][nz] == '*') cnt++
                    }

                    result[r][c][h] = cnt % 10
                }
            }
        }
    }

    for (h in 0 until H) {
        for (r in 0 until R) {
            for (c in 0 until C) {
                sb.append(if (result[r][c][h] == -1) '*' else result[r][c][h])
            }

            sb.appendLine()
        }
    }

    print(sb)
}