fun main() {
    val sb = StringBuilder()
    var num = 0

    while (true) {
        val n = readln().toInt()

        if (n == 0) break
        val arr = Array(n) { readln().split(" ") }
        var cnt = 0

        sb.appendLine("Group ${++num}")

        for (i in 0 until n) {
            for (j in 1 until n) {
                if (arr[i][j] == "N") {
                    sb.appendLine("${arr[(i - j + n) % n][0]} was nasty about ${arr[i][0]}")
                    cnt++
                }
            }
        }

        if (cnt == 0) {
            sb.appendLine("Nobody was nasty")
        }

        sb.appendLine()
    }

    print(sb)
}