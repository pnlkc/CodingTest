fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val find = intArrayOf(readln().toInt(), 0, 0)
    val map = Array(N) { IntArray(N) }
    var cnt = 0
    var num = N * N
    var y = 0
    var x = 0

    while (y != N / 2 && x != N) {
        for (i in cnt until N - cnt) {
            map[i][x] = num--
        }

        y = N - 1 - cnt

        for (j in cnt + 1 until N - cnt) {
            map[y][j] = num--
        }

        x = N - 1 - cnt

        for (i in y - 1 downTo cnt) {
            map[i][x] = num--
        }

        y = cnt
        cnt++

        for (j in x - 1 downTo cnt) {
            map[y][j] = num--
        }

        x = cnt
    }

    map[N / 2][N / 2] = 1

    for (i in 0 until N) {
        for (j in 0 until N) {
            sb.append(map[i][j])
            if (j != N - 1) sb.append(" ")

            if (map[i][j] == find[0]) {
                find[1] = i
                find[2] = j
            }
        }

        sb.appendLine()
    }

    sb.appendLine("${find[1] + 1} ${find[2] + 1}")

    print(sb)
}