var n = 0
var m = 0
var list = listOf<Int>()
var pick = intArrayOf()
val set = mutableSetOf<String>()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    n = N
    m = M
    list = readln().split(" ").map { it.toInt() }.sorted()
    pick = IntArray(m)

    pick(0, 0)
    println(set.joinToString("\n"))
}

fun pick(idx: Int, pIdx: Int) {
    if (pIdx == m) {
        set.add(pick.joinToString(" "))
        return
    }

    if (idx >= n) return

    for (i in idx until n) {
        pick[pIdx] = list[i]
        pick(i + 1, pIdx + 1)
        pick(i + 1, pIdx)
    }
}