data class Data(val u: Int, val v: Int)

fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val arr = Array(N - 1) { Data(-1, -1) }
    val cnt = IntArray(N + 1)

    for (i in 0 until N - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        arr[i] = Data(a, b)
        cnt[a]++
        cnt[b]++
    }

    val q = readln().toInt()

    for (tc in 1..q) {
        val (t, k) = readln().split(" ").map { it.toInt() }

        if (t == 1) {
            sb.appendLine(if (cnt[k] > 1) "yes" else "no")
        } else {
            sb.appendLine("yes")
        }
    }

    print(sb)
}