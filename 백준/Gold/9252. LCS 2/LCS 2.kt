fun main() {
    val s1 = readln()
    val s2 = readln()
    val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
            else dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
        }
    }

    var i = s1.length
    var j = s2.length
    val sb = StringBuilder()

    while (i > 0 && j > 0) {
        if (s1[i - 1] == s2[j - 1]) {
            sb.append(s1[--i])
            j--
        } else {
            if (dp[i][j] == dp[i -1][j]) i-- else j--
        }
    }

    println(sb.length)
    println(sb.reverse())
}