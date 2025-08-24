import kotlin.math.abs

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val S = readln()
    val T = readln()
    val min = minOf(N, M)
    val minC = if (N <= M) '0' else '1'
    val posS = IntArray(min)
    val posT = IntArray(min)
    var idxS = 0
    var idxT = 0
    var cntS = 0
    var cntT = 0

    for (i in 0 until N + M) {
        if (S[i] == minC) posS[idxS++] = i
    }

    for (i in 0 until N + M) {
        if (T[i] == minC) posT[idxT++] = i
    }
    
    for (i in 0 until min) {
        val abs = abs(posS[i] - posT[i])

        cntS += abs / 2
        cntT += abs / 2

        if (abs % 2 == 1) {
            if (cntS <= cntT) cntS++ else cntT++
        }
    }

    println(cntS.toLong() * cntS + cntT.toLong() * cntT)
}