fun main() {
    val P = readln().toDouble() * 1_000_000_000
    var bot = 1_000_000_000L
    var top = P.toLong()
    val gcd = gcd(top, bot)

    top /= gcd
    bot /= gcd

    val result = LongArray(6)
    val mid = top / bot
    val diff = top - bot * mid

    result[mid.toInt()] = bot
    if (diff != 0L) {
        result[mid.toInt()] -= diff
        result[mid.toInt() + 1] += diff
    }

    println(result.drop(1).joinToString(" "))
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)