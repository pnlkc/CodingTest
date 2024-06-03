fun main() {
    val N = readln().toInt()
    val dp = Array(N + 1) { IntArray(N + 1) }
    val primeList = BooleanArray(1_000_001) { true }

    initPrimeList(primeList)
    calc(N, N, primeList, dp)
    println(dp[N][N])
}

fun initPrimeList(primeList: BooleanArray) {
    for (i in 2..1_000_000){
        var num = i * 2

        while (num <= 1_000_000) {
            primeList[num] = false
            num += i
        }
    }
}

fun calc(a: Int, b: Int, primeList: BooleanArray, dp: Array<IntArray>): Int {
    if (a == 1 && b == 1) return 0

    if (dp[a][b] != 0) return dp[a][b]

    dp[a][b] = maxOf(
        if (a - 1 < 1)  0 else calc(a - 1, b, primeList, dp),
        if (b - 1 < 1) 0 else calc(a, b - 1, primeList, dp)
    )

    if (primeList[(a.toString() + b).toInt()]) dp[a][b]++

    return dp[a][b]
}