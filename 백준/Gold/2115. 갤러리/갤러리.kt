fun main() {
    val (M, N) = readln().split(" ").map { it.toInt() }
    val map = Array(M) { CharArray(N) }
    val isUsed = Array(M) { Array(N) { BooleanArray(4) } }
    var result = 0

    for (i in 0 until M) {
        val input = readln()

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    for (i in 1 until M - 1) {
        for (j in 1 until N - 1) {
            if (map[i][j] == 'X') continue

            if (!isUsed[i][j][0] && map[i - 1][j] == 'X' && map[i - 1][j + 1] == 'X' && map[i][j + 1] == '.') {
                if (!isUsed[i][j + 1][0]) {
                    result++
                    isUsed[i][j][0] = true
                    isUsed[i][j + 1][0] = true
                }
            }

            if (!isUsed[i][j][1] && map[i][j + 1] == 'X' && map[i + 1][j + 1] == 'X' && map[i + 1][j] == '.') {
                if (!isUsed[i + 1][j][1]) {
                    result++
                    isUsed[i][j][1] = true
                    isUsed[i + 1][j][1] = true
                }
            }

            if (!isUsed[i][j][2] && map[i + 1][j] == 'X' && map[i + 1][j + 1] == 'X' && map[i][j + 1] == '.') {
                if (!isUsed[i][j + 1][2]) {
                    result++
                    isUsed[i][j][2] = true
                    isUsed[i][j + 1][2] = true
                }
            }

            if (!isUsed[i][j][3] && map[i][j - 1] == 'X' && map[i + 1][j - 1] == 'X' && map[i + 1][j] == '.') {
                if (!isUsed[i + 1][j][3]) {
                    result++
                    isUsed[i][j][3] = true
                    isUsed[i + 1][j][3] = true
                }
            }
        }
    }

    println(result)
}