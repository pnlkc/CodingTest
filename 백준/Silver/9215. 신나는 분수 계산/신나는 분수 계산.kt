import java.math.BigInteger

fun main() {
    val sb = StringBuilder()
    var num = 1

    while(true) {
        val N = readln().toInt()
        if (N == 0) break
        var x = BigInteger.ZERO
        var t = BigInteger.ONE
        var b = BigInteger.ONE

        for (i in 1..N) {
            val input = readln()
            var w = BigInteger.ZERO
            var n = BigInteger.ZERO
            var d = BigInteger.ONE

            if (input.contains(",")) {
                val split = input.split(",", "/").map { it.toInt() }
                w = split[0].toBigInteger()
                n = split[1].toBigInteger()
                d = split[2].toBigInteger()
            } else if (input.contains("/")) {
                val split = input.split("/").map { it.toInt() }
                n = split[0].toBigInteger()
                d = split[1].toBigInteger()
            } else {
                w = input.toBigInteger()
            }

            n = n.add(d.multiply(w))

            if (i == 1) {
                t = n
                b = d
            } else {
                val tempT1 = t.multiply(d)
                val tempT2 = n.multiply(b)
                val tempT = tempT1.add(tempT2)
                val tempB = d.multiply(b)
                val gcd = gcd(tempT, tempB)

                t = tempT.divide(gcd)
                b = tempB.divide(gcd)
            }
        }

        if (t >= b) {
            x = t.divide(b)

            if (t.mod(b) == BigInteger.ZERO) {
                sb.appendLine("Test $num: $x")
            } else {
                sb.appendLine("Test $num: $x,${t.mod(b)}/$b")
            }
        } else {
            if (t == BigInteger.ZERO) {
                sb.appendLine("Test $num: 0")
            } else {
                sb.appendLine("Test $num: $t/$b")
            }
        }

        num++
    }

    print(sb)
}

fun gcd(a: BigInteger, b: BigInteger): BigInteger {
    return if (b == BigInteger.ZERO) a else gcd(b, a.mod(b))
}