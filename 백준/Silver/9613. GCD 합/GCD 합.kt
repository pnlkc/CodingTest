fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..t) {
        val input = readln().split(" ").map { it.toInt() }
        var sum = 0L

        for (j in 1 until input[0]) {
            for (k in j + 1..input[0]) {
                sum += gcd(input[j], input[k])
            }
        }

        sb.appendLine(sum)
    }

    print(sb)
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)