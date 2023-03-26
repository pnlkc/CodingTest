fun main() {
    val num = readln().toInt()
    val memo = Array(num) { IntArray(num) }

    repeat(num) {
        val line = readln().split(" ").map { split -> split.toInt() }

        if (it == 0) {
            memo[0][0] = line[0]
        } else {
            for (i in 0..it) {
                val range = 0 until num
                memo[it][i] = maxOf(
                    if (it - 1 in range && i in range) memo[it - 1][i] + line[i] else 0,
                    if (it - 1 in range && i - 1 in range) memo[it - 1][i - 1] + line[i] else 0
                )
            }
        }
    }

    println(memo.last().maxOrNull()!!)
}