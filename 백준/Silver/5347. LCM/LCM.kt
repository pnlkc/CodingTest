fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (tc in 1..n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val gcd = gcd(a, b)

        sb.appendLine(a.toLong() * b / gcd)
    }

    print(sb)
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}