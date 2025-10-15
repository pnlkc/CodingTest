fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val map = readln().split(" ").associateWith { 0 }.toMutableMap()

    for (i in 0 until n) {
        val sL = readln().split(" ")

        for (s in sL) {
            map[s] = map[s]!! + 1
        }
    }

    val result = map.toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })

    for (i in 0 until n) {
        sb.appendLine("${result[i].first} ${result[i].second}")
    }

    print(sb)
}