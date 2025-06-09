fun main() {
    val sb = StringBuilder()
    val Q = readln().toInt()

    for (tc in 1..Q) {
        val (ta, tb, va, vb) = readln().split(" ").map { it.toInt() }
        var time = 0
        var a = 0
        var aCnt = 0
        var b = 0
        var bCnt = 0

        while (va > aCnt || vb > bCnt) {
            time++

            if (va > aCnt) {
                if (a + ta == time) {
                    aCnt++
                    a = a + ta
                }
            }

            if (vb > bCnt) {
                if (b + tb == time) {
                    bCnt++
                    b = b + tb
                }
            } else {
                if (b + ta == time) {
                    aCnt++
                    b = b + ta
                }
            }
        }

        sb.appendLine(time)
    }

    print(sb)
}