import java.lang.StringBuilder

fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    for (i in 1 until N) {
        val gcd = gcd(list[0], list[i])

        sb.appendLine("${list[0] / gcd}/${list[i] / gcd}")
    }

    print(sb)
}

fun gcd(a: Int, b: Int): Int = if (b != 0)  gcd(b, a % b) else a