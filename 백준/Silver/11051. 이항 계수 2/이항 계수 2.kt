fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var top = 1.toBigInteger()
    var bot = 1.toBigInteger()

    for (i in n downTo n - k + 1) {
        top = top.multiply(i.toBigInteger())
    }

    for (i in 1..k) {
        bot = bot.multiply(i.toBigInteger())
    }

    println(top.divide(bot).mod(10_007.toBigInteger()))
}