fun main() {
    val sb = StringBuilder()
    val MAX = 1_000_000

    p@while (true) {
        val N = readln().toInt()
        if (N == -1) break

        var cnt: Int

        for (i in MAX downTo 2) {
            cnt = N

            for (j in 1..i) {
                cnt--
                if (cnt % i != 0) break
                cnt -= cnt / i
            }

            if (cnt % i == 0) {
                sb.appendLine("$N coconuts, $i people and 1 monkey")
                continue@p
            }
        }

        sb.appendLine("$N coconuts, no solution")
    }

    print(sb)
}