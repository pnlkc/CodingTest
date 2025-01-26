import kotlin.math.pow

fun main() {
    val (A, B) = readln().split(" ").map { it.toLong() }
    var cnt = 0

    while (2.0.pow(cnt + 1) <= B) {
        cnt++
    }

    val dp = LongArray(cnt + 1)

    dp[0] = 1

    for (i in 1..cnt) {
        dp[i] = 2.0.pow(i).toLong() + dp[i - 1] * 2
    }
    
    val aStr = (A - 1).toString(2)
    var aCnt = 0L
    val aL = aStr.lastIndex
    val bStr = B.toString(2)
    var bCnt = 0L
    val bL = bStr.lastIndex

    for (i in aStr.indices) {
        if (aStr[i] == '1') {
            if (aL - i - 1 >= 0) aCnt += dp[aL - i - 1]
            if (aStr.slice(i + 1..aL).isNotEmpty()) aCnt += aStr.slice(i + 1..aL).toLong(2)
            aCnt++
        }
    }

    for (i in bStr.indices) {
        if (bStr[i] == '1') {
            if (bL - i - 1 >= 0) bCnt += dp[bL - i - 1]
            if (bStr.slice(i + 1..bL).isNotEmpty()) bCnt += bStr.slice(i + 1..bL).toLong(2)
            bCnt++
        }
    }
    
    println(bCnt - aCnt)
}