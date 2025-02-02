fun main() {
    val n = readln().toInt()
    val map = Array(n) { CharArray(n) }
    val result = Array(n) { CharArray(n) }
    val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    var isOpen = false

    for (i in 0 until n) {
        val input = readln()

        for (j in 0 until n) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until n) {
        val input = readln()

        for (j in 0 until n) {
            if (input[j] == 'x') {
                if (map[i][j] == '*') {
                    isOpen = true
                } else {
                    var cnt = 0

                    for (d in 0..7) {
                        val nx = j + dx[d]
                        val ny = i + dy[d]

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
                        if (map[ny][nx] == '*') cnt++
                    }

                    result[i][j] = cnt.digitToChar()
                }
            } else {
                result[i][j] = '.'
            }
        }
    }

    if (isOpen) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j] == '*') {
                    result[i][j] = '*'
                }
            }
        }
    }

    for (i in 0 until n) {
        println(result[i].joinToString(""))
    }
}