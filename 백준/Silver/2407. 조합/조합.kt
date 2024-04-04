import java.math.BigInteger

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var result = BigInteger.ONE

    for (i in n downTo (n - m + 1)) {
        result = result.multiply(i.toBigInteger())
    }

    for (i in 1..m) {
        result = result.divide(i.toBigInteger())
    }

    println(result)
}