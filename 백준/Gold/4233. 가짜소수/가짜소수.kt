import kotlin.math.sqrt

data class Data(val p: Long, val a: Long)

fun main() {
    val sb = StringBuilder()
    val isPrime = mutableMapOf<Long, Boolean>()

    while (true) {
        val (p, a) = readln().split(" ").map { it.toLong() }

        if (p == 0L && a == 0L) break
        if (isPrime[p] == null) isPrime[p] = checkPrime(p)
        if (isPrime[p]!!) {
            sb.appendLine("no")
            continue
        }

        val result = calc(p, a, mutableMapOf(Data(1, a) to a), p)

        sb.appendLine(if (result == a) "yes" else "no")
    }

    print(sb)
}

fun checkPrime(n: Long): Boolean {
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0L) return false
    }

    return true
}

fun calc(p: Long, a: Long, dp: MutableMap<Data, Long>, mod: Long): Long {
    if (dp[Data(p, a)] != null) return dp[Data(p, a)]!!

    val f = calc(p / 2, a, dp, mod)
    val b = calc(p / 2 + p % 2, a, dp, mod)

    dp[Data(p, a)] = (f * b) % mod

    return dp[Data(p, a)]!!
}