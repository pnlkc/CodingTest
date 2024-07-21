import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val list = Array(n) { "" }
    var result = 0

    for (i in 0 until n) {
        list[i] = readln()
    }

    val cntF = IntArray(26)
    val cntS = IntArray(26)

    for (c in list[0]) {
        cntF[c - 'A']++
    }

    for (i in 1 until n) {
        cntS.fill(0)
        var fDiff = 0
        var sDiff = 0

        for (c in list[i]) {
            cntS[c - 'A']++
        }

        var diff = 0

        for (i in 0 until 26) {
            diff += abs(cntF[i] - cntS[i])
            if (cntF[i] > cntS[i]) fDiff += cntF[i] - cntS[i]
            else sDiff += cntS[i] - cntF[i]
        }

        if (diff < 2) result++
        else if (list[0].length == list[i].length && fDiff == 1 && sDiff == 1) {
            result++
        }
    }

    println(result)
}