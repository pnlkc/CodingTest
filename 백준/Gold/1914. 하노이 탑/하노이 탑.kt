import java.math.BigInteger

var cnt = 0
val sb = StringBuilder()

fun main() {
    val N = readln().toInt()

    if (N <= 20) {
        play(N, 1, 3)

        println(cnt)
        print(sb)
    } else {
        var result = BigInteger.ONE

        for (i in 1..N) {
            result = result.multiply(2.toBigInteger())
        }

        println(result.minus(BigInteger.ONE))
    }
}

fun play(n: Int, ori: Int, dest: Int) {
    if (n >= 1) {
        play(n - 1, ori, pick(ori, dest))

        cnt++
        sb.appendLine("$ori $dest")

        play(n - 1, pick(ori, dest), dest)
    }
}

fun pick(num1: Int, num2: Int): Int {
    return when {
        num1 == 1 && num2 == 2 -> 3
        num1 == 1 && num2 == 3 -> 2
        num1 == 2 && num2 == 1 -> 3
        num1 == 2 && num2 == 3 -> 1
        num1 == 3 && num2 == 1 -> 2
        else -> 1
    }
}