import java.math.BigInteger

fun main() {
    val sb = StringBuilder()
    var n = ""

    while (true) {
        n = readlnOrNull() ?: break
        val nBigInteger = BigInteger.valueOf(n.toLong())
        var num = BigInteger.ONE

        while (num.mod(nBigInteger) != BigInteger.ZERO) {
            num = num.multiply(BigInteger.TEN).plus(BigInteger.ONE)
        }

        sb.appendLine(num.toString().length)
    }

    print(sb)
}