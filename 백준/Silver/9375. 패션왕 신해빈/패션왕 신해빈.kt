fun main() {
    val sb = StringBuilder()

    repeat(readln().toInt()) {
        val n = readln().toInt()
        val map = mutableMapOf<String, Int>()

        repeat(n) {
            val (name, c) = readln().split(' ')
            if (map[c] == null) map[c] = 1 else map[c] = map[c]!! + 1
        }

        sb.appendLine(map.values.fold(1) { acc, i -> acc * (i + 1) } - 1)
    }

    println(sb)
}