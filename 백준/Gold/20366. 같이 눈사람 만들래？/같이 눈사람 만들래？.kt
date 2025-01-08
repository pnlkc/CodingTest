import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var result = Int.MAX_VALUE

    p@for (i in 0 until N - 1) {
        for (j in i + 1 until N) {
            val sum1 = list[i] + list[j]

            var s = 0
            var e = N - 1

            while (s < e) {
                if (s == i || s == j) {
                    s++
                    continue
                }

                if (e == j || e == i) {
                    e--
                    continue
                }

                result = minOf(result, abs(sum1 - list[s] - list[e]))

                when {
                    list[s] + list[e] > sum1 -> e--
                    list[s] + list[e] < sum1 -> s++
                    else -> {
                        result = 0
                        break@p
                    }
                }
            }
        }
    }

    println(result)
}