import java.math.BigInteger

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    val NUM = (1_000_000_007).toBigInteger()

    var result = BigInteger.ONE

    for (i in N downTo N - K + 1) {
        result = result.multiply(i.toBigInteger())
    }

    for (i in 1..K) {
        result = result.divide(i.toBigInteger())
    }

    repeat(K - 1) {
        result = result.multiply((2).toBigInteger())
    }

    println(result.mod(NUM))
}