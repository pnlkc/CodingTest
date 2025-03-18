var aL = mutableListOf<Int>()
var rArr = arrayOf<IntArray>()
var mArr = arrayOf<IntArray>()
var max = 0

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    aL = readln().split(" ").map { it.toInt() }.toMutableList()
    rArr = Array(K) { IntArray(N) }
    mArr = Array(K) { IntArray(N) }

    for (i in 0 until K) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            rArr[i][j] = input[j]
        }
    }

    for (i in 0 until K) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until N) {
            mArr[i][j] = input[j]
        }
    }

    calc(0, 0, 0, K, N)

    println(max)
}

fun calc(idx: Int, rSum: Int, mSum: Int, k: Int, n: Int) {
    if (idx == k) {
        max = maxOf(max, rSum + mSum)
        return
    }

    for (i in 0 until n) {
        if (aL[i] <= 0) continue

        aL[i]--

        for (j in 0 until n) {
            if (aL[j] <= 0) continue

            aL[j]--
            calc(idx + 1, rSum + rArr[idx][i], mSum + mArr[idx][j], k, n)
            aL[j]++
        }

        aL[i]++
    }
}