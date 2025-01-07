import java.math.BigInteger
import java.math.RoundingMode

fun main() {
    val M = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val K = readln().toInt()
    var top = BigInteger.ZERO
    var bot = BigInteger.ONE
    var kSum = BigInteger.ONE

    for (i in list.sum() downTo list.sum() - K + 1) {
        bot = bot.multiply(i.toBigInteger())
    }

    for (i in 1..K) {
        kSum = kSum.multiply(i.toBigInteger())
    }

    bot = bot.divide(kSum)

    for (num in list) {
        if (num < K) continue

        var temp = BigInteger.ONE

        for (i in num downTo num - K + 1) {
            temp = temp.multiply(i.toBigInteger())
        }

        temp = temp.divide(kSum)

        top = top.add(temp)
    }

    println(top.toBigDecimal().divide(bot.toBigDecimal(), 20, RoundingMode.CEILING))
}