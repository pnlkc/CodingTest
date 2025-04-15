import java.math.BigInteger

fun main() {
    val S = readln()
    val N = readln().toInt()
    val sCnt = IntArray(26)
    val nCnt = IntArray(26)
    var top = BigInteger.ONE
    var bottom = BigInteger.ONE

    for (i in 0..2) {
        sCnt[S[i] - 'A']++
    }

    for (i in 1..N) {
        nCnt[readln()[0] - 'A']++
    }

    for (i in 0..25) {
        if (sCnt[i] == 0) continue

        for (j in 1..sCnt[i]) {
            top = top.multiply(nCnt[i].toBigInteger().minus(j.toBigInteger()).plus(BigInteger.ONE))
            bottom = bottom.multiply(j.toBigInteger())
        }
    }

    println(top.divide(bottom))
}