fun main() {
    val sb = StringBuilder()
    
    while (true) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        if (N == 0 && M == 0) break
        val map = mutableMapOf<Int, Boolean>()
        var cnt = 0

        for (i in 0 until N) {
            val num = readln().toInt()
            map[num] = true
        }

        for (i in 0 until M) {
            val num = readln().toInt()
            if (map[num] != null) cnt++
        }

        sb.appendLine(cnt)
    }
    
    print(sb)
}