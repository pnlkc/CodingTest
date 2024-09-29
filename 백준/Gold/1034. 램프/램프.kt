fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { IntArray(M) }
    var max = 0

    for (i in 0 until N) {
        val input = readln()

        for (j in 0 until M) {
            map[i][j] = input[j].digitToInt()
        }
    }

    val K = readln().toInt()

    for (i in 0 until N) {
        val temp = Array(N) { IntArray(M) }
        copy(N, M, map, temp)
        var cnt = 0

        for (j in 0 until M) {
            if (map[i][j] == 0) {
                cnt++
                for (k in 0  until N) {
                    temp[k][j] = (temp[k][j] + 1) % 2
                }
            }
        }

        if (cnt > K) continue

        var zeroCnt = 0
        var oneCnt = 0

        for (k in 0 until N) {
            if (!temp[k].contains(1)) zeroCnt++
            if (!temp[k].contains(0)) oneCnt++
        }

        if ((K - cnt) % 2 == 0) max = maxOf(max, oneCnt)
        if ((K - cnt) % M == 0 && (K - cnt) / M % 2 == 1) max = maxOf(max, zeroCnt)
    }

    println(max)
}

fun copy(n: Int, m: Int, ori: Array<IntArray>, dest: Array<IntArray>) {
    for (i in 0 until n) {
        for (j in 0 until m) {
            dest[i][j] = ori[i][j]
        }
    }
}