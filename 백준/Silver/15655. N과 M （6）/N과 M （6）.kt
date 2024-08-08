val sb = StringBuilder()
lateinit var pick: IntArray

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    pick = IntArray(M)

    calc(N, M, list, 0, 0)

    print(sb)
}

fun calc(N: Int, M: Int, list: List<Int>, idx: Int, cnt: Int) {
    if (cnt == M) {
        sb.appendLine(pick.joinToString(" "))
        return
    }

    if (idx == N) return

    pick[cnt] = list[idx]
    calc(N, M, list, idx + 1, cnt + 1)
    calc(N, M, list, idx + 1, cnt)
}