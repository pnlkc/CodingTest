fun main() {
    val N = readln().toInt()
    val map = Array(N) { CharArray(N) }
    val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
    val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1)
    var x = 0
    var y = 0
    var result = 0

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until N) {
            map[i][j] = input[j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] != '.') continue

            var sum = 0

            p@ for (d in 0 until 8) {
                var cnt = 0

                for (k in 1 until N) {
                    val nx = j + dx[d] * k
                    val ny = i + dy[d] * k

                    if (nx in 0 until N && ny in 0 until N) {
                        when (map[ny][nx]) {
                            'W' -> cnt++
                            'B' -> {
                                sum += cnt
                                continue@p
                            }
                            '.' -> continue@p
                        }
                    }
                }
            }

            if (result < sum) {
                result = sum
                x = j
                y = i
            }
        }
    }

    println(if(result == 0) "PASS" else "$x $y\n$result")
}