val sb = StringBuilder()
var n = 0
var m = 0
var arr = intArrayOf()
var pick = intArrayOf()

fun main() {
    val input = readln().split(" ").map { it.toInt() }

    m = input[1]
    arr = readln().split(" ").distinct().map { it.toInt() }.toIntArray().sortedArray()
    n = arr.size
    pick = IntArray(m)

    pick(0)

    print(sb)
}

fun pick(idx: Int) {
    if (idx == m) {
        sb.appendLine(pick.joinToString(" "))
        return
    }

    for (i in 0 until n) {
        pick[idx] = arr[i]
        pick(idx + 1)
    }
}