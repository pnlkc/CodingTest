fun main() {
    calc((1).toBigInteger(), readln().toInt())
}

fun calc(answer: java.math.BigInteger, i: Int) {
    if (i <= 1) println(answer) else calc(answer.multiply(i.toBigInteger()), i - 1)
}