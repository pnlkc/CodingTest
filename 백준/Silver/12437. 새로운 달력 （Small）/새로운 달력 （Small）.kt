fun main() {
    val sb = StringBuilder()
    val T = readln()

    for (tc in 1..T.toInt()) {
        val (m, md, wd) = readln().split(" ").map { it.toInt() }
        var cnt = 0
        var s = 0

        for (i in 1..m) {
            cnt += (s + md) / wd
            if ((s + md) % wd != 0) cnt++
            s = (s + md) % wd
        }

        sb.appendLine("Case #$tc: $cnt")
    }

    print(sb)
}