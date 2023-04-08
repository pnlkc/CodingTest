fun main() {
    val (n, b) = readln().split(" ").map { it.toLong() }
    val a = Array(n.toInt()) { readln().split(" ").map { it.toInt() % 1000 }.toIntArray() }
    val result = calc(a, b)
    println(result.joinToString("\n") { it.joinToString(" ") })
}

fun calc(a: Array<IntArray>, b: Long): Array<IntArray> {
    return when (b) {
        1L -> a
        else -> {
            val r = calc(a, b / 2)
            val multiplyR = multiply(r, r)
            if (b % 2 == 0L) multiplyR
            else multiply(a, multiplyR)
        }
    }
}

fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
    val n = a.size
    val result = Array(n) { IntArray(n) }
    for (x in 0 until n) {
        for (y in 0 until n) {
            var sum = 0
            for (z in 0 until n) {
                sum += a[x][z] * b[z][y]
                sum %= 1000
            }
            result[x][y] = sum
        }
    }
    return result
}