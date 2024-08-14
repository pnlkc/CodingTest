fun main() {
    val sb = StringBuilder()
    val (H, W) = readln().split(" ").map { it.toInt() }
    var map = Array(H) { CharArray(W) }
    val result = Array(H) { IntArray(W) { -1 } }

    for (i in 0 until H) {
        val input = readln()

        for (j in 0 until W) {
            map[i][j] = input[j]
            if (map[i][j] == 'c') result[i][j] = 0
        }
    }

    for (k in 1 until W) {
        val temp = Array(H) { CharArray(W) { '.' } }

        for (i in 0 until H) {
            for (j in 0 until W) {
                if (j + 1 >= W) break

                if (map[i][j] == 'c') {
                    temp[i][j + 1] = 'c'
                    if (result[i][j + 1] == -1) result[i][j + 1] = k
                }
            }
        }

        map = temp
    }

    for (i in 0 until H) {
        sb.appendLine(result[i].joinToString(" "))
    }

    print(sb)
}