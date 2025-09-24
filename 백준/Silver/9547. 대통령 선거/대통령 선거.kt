fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (c, v) = readln().split(" ").map { it.toInt() }
        val rank = IntArray(c)
        val arr = Array(v) { IntArray(c) }

        for (i in 0 until v) {
            val input = readln().split(" ").map { it.toInt() - 1 }

            rank[input[0]]++

            for (j in 0 until c) {
                arr[i][input[j]] = j + 1
            }
        }

        val sorted = rank.mapIndexed { idx, i -> idx to i }.sortedByDescending { it.second }

        if (sorted.size == 1) {
            sb.appendLine("${sorted[0].first + 1} 1")
            continue
        }

        val f = sorted[0]
        val s = sorted[1]

        if (f.second >= (v + 1) / 2) {
            sb.appendLine("${f.first + 1} 1")
            continue
        }

        var fN = 0
        var sN = 0

        for (i in 0 until v) {
            if (arr[i][f.first] < arr[i][s.first]) fN++ else sN++
        }

        sb.appendLine("${if (fN > sN) f.first + 1 else s.first + 1} 2")
    }

    print(sb)
}