fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()
    val maxMap = mutableMapOf(
        2 to "1",
        3 to "7",
        4 to "4",
        5 to "5",
        6 to "9",
        7 to "8"
    )
    val minMap = mutableMapOf(
        2 to "1",
        3 to "7",
        4 to "4",
        5 to "2",
        6 to "0", // 맨 앞자리인 경우 6
        7 to "8"
    )
    val maxDp = Array(101) { "" }
    val minDp = Array(101) { "" }

    for ((k, v) in maxMap) {
        maxDp[k] = v
    }

    for ((k, v) in minMap) {
        minDp[k] = v
    }

    minDp[6] = "6"

    for (i in 1..100) {
        for (j in 2..7) {
            if (i + j > 100) continue

            if (minDp[i].isNotEmpty()) minDp[i + j] = when {
                minDp[i + j].isEmpty() || minDp[i + j].length > (minDp[i] + minMap[j]!!).length -> minDp[i] + minMap[j]!!
                minDp[i + j].length < (minDp[i] + minMap[j]!!).length -> minDp[i + j]
                else -> minOf(minDp[i + j], minDp[i] + minMap[j]!!)
            }

            if (maxDp[i].isNotEmpty()) maxDp[i + j] = when {
                maxDp[i + j].isEmpty() || maxDp[i + j].length < (maxDp[i] + maxMap[j]!!).length -> maxDp[i] + maxMap[j]!!
                maxDp[i + j].length > (maxDp[i] + maxMap[j]!!).length -> maxDp[i + j]
                else -> maxOf(maxDp[i + j], maxDp[i] + maxMap[j]!!)
            }
        }
    }

    for (tc in 1..t) {
        val n = readln().toInt()

        sb.appendLine("${minDp[n]} ${maxDp[n]}")
    }

    print(sb)
}