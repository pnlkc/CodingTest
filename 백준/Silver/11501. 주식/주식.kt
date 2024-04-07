fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()

    for (i in 0 until T) {
        val N = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }
        var result = 0L
        var s = 0
        val e = N - 1

        while (s < e) {
            val idx= findMax(s, e, list)
            result += (idx - s + 1).toLong() * list[idx] - list.slice(s..idx).sumOf { it.toLong() }
            s = idx + 1
        }

        sb.appendLine(result)
    }

    print(sb)
}

fun findMax(s: Int, e: Int, list: List<Int>): Int {
    val slice = list.slice(s..e)
    val max = slice.max()
    var idx = -1

    for (i in s..e) {
        if (list[i] == max) idx = i
    }

    return idx
}