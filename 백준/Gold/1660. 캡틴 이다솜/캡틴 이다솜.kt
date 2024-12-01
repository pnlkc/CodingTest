fun main() {
    val N = readln().toInt()
    val NUM = 300_000
    val dp = IntArray(N + 1) { NUM }
    var num = 0
    var sum = 0
    val list = mutableListOf<Int>()

    for (i in 1..N) {
        num += i
        sum += num
        if (sum > N) break
        dp[sum] = 1
        list.add(sum)
    }

    for (i in 1..N) {
        for (j in list) {
            if (i + j > N) break

            dp[i + j] = minOf(dp[i + j], dp[i] + 1)
        }
    }
    
    println(dp[N])
}