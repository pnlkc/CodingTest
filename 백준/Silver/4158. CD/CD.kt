fun main() {
    val sb = StringBuilder()
    val map = mutableMapOf<Int, Boolean>()

    while (true) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        if (N == 0 && M == 0) break
        map.clear()
        var cnt = 0
        var last = 0

        for (i in 0 until N) {
            val num = readln().toInt()
            if (i == N - 1) last = num
            map[num] = true
        }

        for (i in 0 until M) {
            val num = readln().toInt()
            if (num > last) continue
            if (map[num] != null) cnt++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}