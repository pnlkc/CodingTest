fun main() {
    val sb = StringBuilder()
    val cost = doubleArrayOf(350.34, 230.90, 190.55, 125.30, 180.90)
    val tc = readln().toInt()

    for (t in 1..tc) {
        var sum = 0.0

        readln().split(" ").map { it.toInt() }.forEachIndexed { idx, cnt -> sum += cost[idx] * cnt }

        sb.appendLine("$${String.format("%.2f", sum)}")
    }

    print(sb)
}