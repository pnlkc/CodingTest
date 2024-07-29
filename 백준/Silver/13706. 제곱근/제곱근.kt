import java.math.BigInteger

fun main() {
    val N = readln().toBigInteger()
    var s = BigInteger.ONE
    var e = N

    while(s < e) {
        val mid = (s + e).divide(2.toBigInteger())

        when {
            mid.multiply(mid) == N -> {
                println(mid)
                return
            }
            mid.multiply(mid) < N -> s = mid
            else -> e = mid
        }
    }
}