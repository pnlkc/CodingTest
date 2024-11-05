fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val N = readln().toInt()
        val list = mutableListOf<Pair<Int, Int>>()

        for (i in 1..N) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            list.add(a to b)
        }

        list.sortBy { it.first }

        var r = 0
        var min = Int.MAX_VALUE

        for ((_, b) in list) {
            if (b < min) {
                min = b
                r++
            }
        }

        sb.appendLine(r)
    }

    print(sb)
}