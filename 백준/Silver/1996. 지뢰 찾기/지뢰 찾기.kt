fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val map = Array(N) { CharArray(N) }
    val cnt = Array(N) { IntArray(N) }
    val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
    val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until N) {
            map[i][j] = input[j]

            if (map[i][j] != '.') {
                for (d in 0..7) {
                    val nx = j + dx[d]
                    val ny = i + dy[d]

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue
                    val num = map[i][j].digitToInt()

                    cnt[ny][nx] += num
                }
            }
        }
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            sb.append(if (map[i][j] != '.') '*' else if (cnt[i][j] > 9)'M' else cnt[i][j])
        }

        sb.appendLine()
    }

    print(sb)
}