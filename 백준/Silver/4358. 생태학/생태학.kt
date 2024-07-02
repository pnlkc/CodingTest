fun main() {
    val sb = StringBuilder()
    var cnt = 0
    val map = mutableMapOf<String, Int>()

    while (true) {
        val input = readlnOrNull() ?: break

        cnt++
        map[input] = if (map[input] == null) 1 else map[input]!! + 1
    }

    for (key in map.keys.sorted()) {
        sb.appendLine("$key ${String.format("%.4f", map[key]!!.toDouble() / cnt * 100)}")
    }

    print(sb)
}