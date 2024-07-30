fun main() {
    val sb = StringBuilder()
    val (K, L) = readln().split(" ").map { it.toInt() }
    var list = mutableListOf<String>()

    for (i in 1..L) {
        list.add(readln())
    }

    list = list
        .reversed()
        .distinct()
        .reversed()
        .toMutableList()

    for (i in 0..minOf(list.lastIndex, K - 1)) {
        sb.appendLine(list[i])
    }

    print(sb)
}