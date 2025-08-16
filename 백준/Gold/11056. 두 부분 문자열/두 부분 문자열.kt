fun main() {
    val A = readln()
    val B = readln()
    val dp = Array(A.length + 1) { IntArray(B.length + 1) }

    for (i in 1..A.length) {
        for(j in 1..B.length) {
            if (A[i - 1] == B[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
            else dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
        }
    }

    println(A.length + B.length - dp[A.length][B.length])
}