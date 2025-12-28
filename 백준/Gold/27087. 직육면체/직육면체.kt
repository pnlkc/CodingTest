fun main() {
    val sb = StringBuilder()

    for (t in 1..readln().toInt()) {
        val list = readln().split(" ").map { it.toInt() }
        var cnt = 0

        (0..2).forEach { if (list[it] % list[3] == 0) cnt++ }
        sb.appendLine(if (cnt >= 2) 1 else 0)
    }

    print(sb)
}