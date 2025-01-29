import java.math.BigInteger

fun main() {
    val N = readln().toInt()
    val nL = readln().split(" ").map { it.toInt() }
    val M = readln().toInt()
    val mL = readln().split(" ").map { it.toInt() }

    var nN = BigInteger.ONE
    var mN = BigInteger.ONE

    nL.forEach { nN = nN.multiply(it.toBigInteger()) }
    mL.forEach { mN = mN.multiply(it.toBigInteger()) }

    val result = gcd(nN, mN)
    val rStr = result.toString()

    if (rStr.length > 9) {
        for (i in rStr.lastIndex - 8..rStr.lastIndex) {
            print(rStr[i])
        }
        println()
    } else {
        println(result)
    }
}

fun gcd(a: BigInteger, b: BigInteger): BigInteger {
    return if (b != BigInteger.ZERO) gcd(b, a.mod(b)) else a
}