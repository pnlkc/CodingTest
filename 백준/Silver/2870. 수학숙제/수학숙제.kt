fun main() {
    val sb = StringBuilder()
    val M = readln().toInt()
    val list = mutableListOf<String>()

    for (i in 1..M) {
        val input = readln()
        var prev = ""

        input.forEach { c ->
            if (c.isDigit()) {
                prev += c
            } else {
                if (prev.isNotEmpty()) {
                    if (prev.count { it == '0' } == prev.length) list.add("0") else list.add(prev.trimStart { it == '0' })
                }
                prev = ""
            }
        }

        if (prev.isNotEmpty()) {
            if (prev.count { it == '0' } == prev.length) list.add("0") else list.add(prev.trimStart { it == '0' })
        }
    }

    list.sortWith(compareBy<String> { it.length }.thenComparing { a, b -> a.compareTo(b) })
    list.forEach { sb.appendLine(it) }
    print(sb)
}