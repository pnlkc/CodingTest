fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val W = readln()
        val K = readln().toInt()
        var isExist = false
        var min = Integer.MAX_VALUE
        var max = 0

        for (c in 'a'..'z') {
            if (W.count { it == c } >= K) {
                isExist = true
                val idxList = mutableListOf<Int>()

                for (i in W.indices) {
                    if (W[i] == c) idxList.add(i)
                }

                for (i in 0..idxList.size - K) {
                    val length = idxList[i + K - 1] - idxList[i] + 1

                    min = minOf(min, length)
                    max = maxOf(max, length)
                }
            }
        }

        sb.appendLine(if (isExist) "$min $max" else -1)
    }

    print(sb)
}