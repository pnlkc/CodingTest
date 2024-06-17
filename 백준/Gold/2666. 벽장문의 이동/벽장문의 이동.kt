import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (o1, o2) = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    val list = mutableListOf<Int>().apply { repeat(m) { add(readln().toInt()) } }
    val dp = Array(m) { Array(n + 1) { IntArray(n + 1) } }

    print(calc(0, o1, o2, list, dp))
}

fun calc(idx: Int, o1: Int, o2: Int, list: MutableList<Int>, dp: Array<Array<IntArray>>): Int {
    if (idx == list.size) {
        return 0
    }

    if (dp[idx][o1][o2] == 0) {
        val num = list[idx]
        dp[idx][o1][o2] = when {
            list[idx] <= o1 -> abs(o1 - num) + calc(idx + 1, num, o2, list, dp)
            list[idx] >= o2 -> abs(o2 - num) + calc(idx + 1, o1, num, list, dp)
            else -> {
                minOf(
                    abs(o1 - num) + calc(idx + 1, num, o2, list, dp),
                    abs(o2 - num) + calc(idx + 1, o1, num, list, dp)
                )
            }
        }
    }

    return dp[idx][o1][o2]
}