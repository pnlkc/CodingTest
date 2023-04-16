fun main() {
    val n = readln().toLong()
    println(calc(n, mutableMapOf()))
}

fun calc(n: Long, memo: MutableMap<Long, Long>): Long {
    if (n == 0L) return 0L
    if (n == 1L) return 1L
    if (n == 2L) return 1L
    if (n == 3L) return 2L

    var result = 0L
    val MMinus1 = memo[n / 2 - 1] ?: calc(n / 2 - 1, memo)
    val N = memo[if (n % 2 == 0L) n / 2 else n / 2 + 1] ?: calc(if (n % 2 == 0L) n / 2 else n / 2 + 1, memo)
    val M = memo[n / 2] ?: calc(n / 2, memo)
    val NPlus1 = memo[if (n % 2 == 0L) n / 2 + 1 else n / 2 + 2] ?: calc(if (n % 2 == 0L) n / 2 + 1 else n / 2 + 2, memo)

    result += MMinus1 * N + M * NPlus1
    result %= 1_000_000_007
    memo[n] = result

    return result
}