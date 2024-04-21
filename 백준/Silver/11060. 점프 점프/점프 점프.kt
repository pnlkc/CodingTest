fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val dp = IntArray(N) { Int.MAX_VALUE }

    dp[0] = 0
    calc(0, 0, list, dp)

    println(if (dp.last() == Int.MAX_VALUE) -1 else dp.last())
}

fun calc(idx: Int, r: Int, list: List<Int>, dp: IntArray) {
    for (i in 1..list[idx]) {
        if (idx + i >= list.size) continue
        if (dp[idx + i] <= r + 1) continue

        dp[idx + i] = r + 1

        calc(idx + i, r + 1, list, dp)
    }
}