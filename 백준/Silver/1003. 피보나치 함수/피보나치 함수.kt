fun main() {
    val sb = StringBuilder()
    val memo = mutableMapOf<Int, IntArray>()
    memo[0] = intArrayOf(1, 0)
    memo[1] = intArrayOf(0, 1)

    repeat(readln().toInt()) {
        val answer = intArrayOf(0, 0)
        val n = readln().toInt()

        fibonacci(n, memo)
        sb.appendLine(memo[n]!!.joinToString(" "))
    }

    println(sb)
}

fun fibonacci(n: Int, memo: MutableMap<Int, IntArray>): IntArray {
    if (memo[n] != null) return memo[n]!!

    val n1 = fibonacci(n - 1, memo)
    val n2 = fibonacci(n - 2, memo)

    memo[n] = intArrayOf(n1[0] + n2[0], n1[1] + n2[1])
    return memo[n]!!
}