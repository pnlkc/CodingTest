var data = arrayOf<IntArray>()
var pick = IntArray(11)
var result = 0

fun main() {
    val sb = StringBuilder()
    val C = readln().toInt()

    for (tc in 0 until C) {
        data = Array(11) { IntArray(11) }
        pick = IntArray(11)
        result = 0

        for (i in 0 until 11) {
            data[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        }

        calc(0)
        sb.appendLine(result)
    }

    print(sb)
}

fun calc(idx: Int) {
    if (idx == 11 && !pick.contains(0)) {
        result = maxOf(result, pick.sum())
        return
    }

    for (i in 0 until 11) {
        if (data[idx][i] == 0) continue
        if (pick[i] != 0) continue

        pick[i] = data[idx][i]
        calc(idx + 1)
        pick[i] = 0
    }
}