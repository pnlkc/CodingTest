fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    var cnt = list[0]

    for (i in 1 until N) {
        if (list[i] == 1 && list[i - 1] != 1) cnt++
    }

    for (i in 0 until M) {
        val c = readln()

        if (c.startsWith("0")) {
            sb.appendLine(cnt)
        } else {
            val (_, num) = c.split(" ").map { it.toInt() - 1 }

            if (list[num] == 1) continue

            if (num > 0) {
                if (list[num - 1] == 1 && num + 1 < N && list[num + 1] == 1) cnt--
                else if (list[num - 1] == 0) {
                    if (num + 1 < N) {
                        if (list[num + 1] == 0) cnt++
                    } else {
                        cnt++
                    }
                }
            } else {
                if (list[1] != 1) cnt++
            }

            list[num] = 1
        }
    }

    print(sb)
}