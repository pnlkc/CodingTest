fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (j, N) = readln().split(" ").map { it.toInt() }
        val arr = IntArray(N)
        var candy = j
        var cnt = 0
        var idx = 0

        for (i in 0 until N) {
            val (r, c) = readln().split(" ").map { it.toInt() }
            arr[i] = r * c
        }

        arr.sortDescending()

        while (candy > 0) {
            candy -= arr[idx++]
            cnt++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}