val sb = StringBuilder()
var list = listOf<Int>()
var pick = intArrayOf()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    list = readln().split(" ").map { it.toInt() }.sorted()
    pick = IntArray(M)
    pick(0)
    print(sb)
}

fun pick(cnt: Int) {
    if (cnt == pick.size) {
        sb.appendLine(pick.joinToString(" "))
        return
    }

    for (i in list.indices) {
        pick[cnt] = list[i]
        pick(cnt + 1)
    }
}
