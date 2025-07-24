import java.math.BigInteger

fun main() {
    val sb = StringBuilder()

    while (true) {
        val (n, k) = readln().split(" ").map { it.toInt() }

        if (n == 0 && k == 0) break

        val min = minOf(k, n - k)
        var top = BigInteger.ONE
        var bot = BigInteger.ONE

        for (i in 0 until min) {
            top = top.multiply((n - i).toBigInteger())
            bot = bot.multiply((i + 1).toBigInteger())
        }

        sb.appendLine(top.divide(bot))
    }

    print(sb)
}