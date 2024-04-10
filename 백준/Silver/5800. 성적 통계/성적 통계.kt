fun main() {
    val K = readln().toInt()
    val sb = StringBuilder()

    for (tc in 1..K) {
        val input = readln().split(" ")
        val list = input.slice(1..input.lastIndex).map { it.toInt() }.sorted()
        var largestGap = 0

        for (i in 0 until list.lastIndex) {
            largestGap = maxOf(largestGap, list[i + 1] - list[i])
        }

        sb.appendLine("Class $tc")
        sb.appendLine("Max ${list.last()}, Min ${list.first()}, Largest gap $largestGap")
    }

    print(sb)
}