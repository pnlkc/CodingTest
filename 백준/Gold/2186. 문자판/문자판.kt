fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { CharArray(M) }
    var dp = Array(N) { IntArray(M) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j]
        }
    }

    val str = readln()

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == str.last()) {
                dp[i][j] = 1
            }
        }
    }

    for (idx in str.lastIndex - 1 downTo 0) {
        val temp = Array(N) { IntArray(M) }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] != str[idx + 1]) continue

                for (d in 0..3) {
                    for (l in 1..K) {
                        val nx = j + dx[d] * l
                        val ny = i + dy[d] * l

                        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue
                        if (map[ny][nx] != str[idx]) continue

                        temp[ny][nx] += dp[i][j]
                    }
                }
            }
        }

        dp = copy(N, M, temp)
    }

    var result = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            result += dp[i][j]
        }
    }

    println(result)
}

fun copy(N: Int, M: Int, ori: Array<IntArray>): Array<IntArray> {
    val arr = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        for (j in 0 until M) {
            arr[i][j] = ori[i][j]
        }
    }

    return arr
}