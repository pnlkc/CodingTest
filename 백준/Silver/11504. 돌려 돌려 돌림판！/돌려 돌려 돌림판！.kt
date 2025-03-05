fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val x = readln().split(" ").map { it.toInt() }.joinToString("").toInt()
        val y = readln().split(" ").map { it.toInt() }.joinToString("").toInt()
        val list = readln().split(" ").map { it.toInt() }
        var cnt = 0

        p@ for (i in 0 until N) {
            var num = ""

            for (j in 0 until M) {
                if (i + j >= N && (i + j) % N == i) continue@p
                num += list[(i + j) % N]
            }

            if (num.toInt() in x..y) cnt++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}