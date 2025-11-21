var pick = intArrayOf()
var mL = arrayOf<String>()
var wL = arrayOf<String>()
var max = 0

fun main() {
    val n = readln().toInt()

    mL = Array(n) { "" }
    wL = Array(n) { "" }
    pick = IntArray(n)

    for (i in 0 until n) {
        mL[i] = readln()
    }

    for (i in 0 until n) {
        wL[i] = readln()
    }

    pick(0, n, 0)

    println(max)
}

fun pick(idx: Int, n: Int, sum: Int) {
    if (idx >= n) {
        max = maxOf(max, sum)

        return
    }

    p@ for (i in 0 until n) {
        for (j in 0 until idx) {
            if (pick[j] == i) continue@p
        }

        var cnt = 0

        for (k in 0..3) {
            if (mL[idx][k] != wL[i][k]) cnt++
        }

        pick[idx] = i
        pick(idx + 1, n, sum + cnt)
    }
}