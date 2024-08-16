fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf(
        0 to "zero",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
    )

    (N..M)
        .map {
            it to it.toString().toCharArray().map { c -> map[c.digitToInt()] }.joinToString(" ")
        }
        .sortedBy { it.second }
        .forEachIndexed { idx, pair ->
            if (idx > 0 && idx % 10 == 0) { sb.appendLine() }

            if (idx % 10 != 9 && idx != M - N) { sb.append(pair.first).append(" ") }
            else { sb.append(pair.first) }
        }

    print(sb)
}