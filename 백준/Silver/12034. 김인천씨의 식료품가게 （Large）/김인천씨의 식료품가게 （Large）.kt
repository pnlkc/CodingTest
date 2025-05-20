fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln()
        val p = readln().split(" ").map { it.toInt() }.toMutableList()
        val result = mutableListOf<Int>()

        while (p.isNotEmpty()) {
            result.add(p[0])
            p.remove(p[0] / 3 * 4)
            p.removeAt(0)
        }

        result.sort()
        sb.appendLine("Case #$tc: ${result.joinToString(" ")}")
    }

    print(sb)
}