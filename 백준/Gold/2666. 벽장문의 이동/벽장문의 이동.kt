import kotlin.math.abs

val list = mutableListOf<Int>()
var dp = arrayOf<Array<IntArray>>()

fun main() {
    val n = readln().toInt()
    val (o1, o2) = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    repeat(m) { list.add(readln().toInt()) }
    dp = Array(m) { Array(n + 1) { IntArray(n + 1) } }

    print(calc(0, o1, o2))
}

fun calc(idx: Int, o1: Int, o2: Int): Int {
    if (idx == list.size) return 0

    if (dp[idx][o1][o2] == 0) {
        val num = list[idx]
        dp[idx][o1][o2] = when {
            list[idx] <= o1 -> abs(o1 - num) + calc(idx + 1, num, o2)
            list[idx] >= o2 -> abs(o2 - num) + calc(idx + 1, o1, num)
            else -> {
                minOf(
                    abs(o1 - num) + calc(idx + 1, num, o2),
                    abs(o2 - num) + calc(idx + 1, o1, num)
                )
            }
        }
    }

    return dp[idx][o1][o2]
}