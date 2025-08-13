fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val aL = Array(N) { intArrayOf() }

    for (i in 0 until N) {
        val input = readln().split(" ").map { it.toInt()}
        val arr = IntArray(input[0]) { input[it + 1] }

        aL[i] = arr
    }

    val M = readln().toInt()

    repeat (M) {
        val bL = BooleanArray(51)
        val input = readln().split(" ").map { it.toInt() }

        for (i in 1..input[0]) {
            bL[input[i]] = true
        }

        var cnt = 0

        p@for (i in 0 until N) {
            for (time in aL[i]) {
                if (!bL[time]) continue@p
            }

            cnt++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}