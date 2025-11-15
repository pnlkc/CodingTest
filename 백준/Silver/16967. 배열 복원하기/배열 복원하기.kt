fun main() {
    val sb = StringBuilder()
    val (h, w, x, y) = readln().split(" ").map { it.toInt() }
    val bArr = Array(h + x) { IntArray(w + y) }
    val aArr = Array(h) { IntArray(w) }

    for (i in 0 until h + x) {
        val input = readln().split(" ").map { it.toInt() }

        for (j in 0 until w + y) {
            bArr[i][j] = input[j]
        }
    }

    for (i in 0 until h) {
        for (j in 0 until w) {
            aArr[i][j] = bArr[i][j]

            if (i in x..h + x && j in y..w + y) {
                aArr[i][j] -= aArr[i - x][j - y]
            }
        }
    }

    for (i in 0 until h) {
        sb.appendLine(aArr[i].joinToString(" "))
    }

    print(sb)
}