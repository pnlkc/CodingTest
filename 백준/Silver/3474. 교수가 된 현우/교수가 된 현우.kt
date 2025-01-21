fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toInt()
        var two = 2
        var twoCnt = 0
        var five = 5L
        var fiveCnt = 0

        while (two <= N) {
            twoCnt += N / two
            two *= 2
        }

        while (five <= N) {
            fiveCnt += (N / five).toInt()
            five *= 5
        }

        sb.appendLine(minOf(twoCnt, fiveCnt))
    }

    print(sb)
}